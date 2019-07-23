/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.JobId;
import com.quartz.admin.domain.QuartzJobDetails;
import com.quartz.admin.exception.ServiceException;
import com.quartz.admin.repository.JobDetailRepository;
import com.quartz.admin.service.dto.JobDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class JobService {

    private final JobDetailRepository jobDetailRepository;

    public List<JobDTO> findAll() {
        List<QuartzJobDetails> jobDetails = jobDetailRepository.findAll();

        return JobDTO.from(jobDetails);
    }

    public JobDTO findById(JobId id) {
        QuartzJobDetails jobDetails = jobDetailRepository.findById(id)
                .orElseThrow(() -> new ServiceException("jobDetails is null jobId : " + id));

        return JobDTO.from(jobDetails);
    }

    public void deleteJob(JobId id) {
        //TODO
    }
}
