/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.JobId;
import com.quartz.admin.domain.QuartzJobDetails;
import com.quartz.admin.exception.ServiceException;
import com.quartz.admin.repository.JobDetailRepository;
import com.quartz.admin.service.dto.JobDTO;
import com.quartz.admin.service.dto.TriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class JobService {

    private final JobDetailRepository jobDetailRepository;

    private final TriggerService triggerService;

    public List<JobDTO> findAll() {
        List<QuartzJobDetails> jobDetails = this.jobDetailRepository.findAll();

        return JobDTO.from(jobDetails);
    }

    public JobDTO findById(JobId jobId) {
        QuartzJobDetails jobDetails = this.jobDetailRepository.findById(jobId)
                .orElseThrow(() -> new ServiceException("jobDetails is null jobId : " + jobId));

        return JobDTO.from(jobDetails);
    }

    public void deleteJob(JobId jobId) {
        List<TriggerDTO> triggers = this.triggerService.findByJobId(jobId);

        if(! triggers.isEmpty()) {
            throw new ServiceException("trigger exists... remove trigger");
        }

        jobDetailRepository.deleteById(jobId);
    }
}
