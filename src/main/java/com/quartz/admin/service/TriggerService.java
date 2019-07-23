/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.JobId;
import com.quartz.admin.domain.QuartzTriggers;
import com.quartz.admin.repository.TriggerRepository;
import com.quartz.admin.service.dto.TriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class TriggerService {

    private final TriggerRepository triggerRepository;

    public List<TriggerDTO> findAll() {
        List<QuartzTriggers> triggers = this.triggerRepository.findAll();
        return TriggerDTO.from(triggers);
    }

    public List<TriggerDTO> findByJobId(JobId id) {
        List<QuartzTriggers> triggers = this.triggerRepository.findById_SchedulerNameAndJobGroupAndJobName(id.getSchedulerName(), id.getJobGroup(), id.getJobName());
        return TriggerDTO.from(triggers);
    }
}
