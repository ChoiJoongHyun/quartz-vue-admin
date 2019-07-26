/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.JobId;
import com.quartz.admin.domain.QuartzTriggers;
import com.quartz.admin.domain.TriggerId;
import com.quartz.admin.exception.ServiceException;
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

    private final SimpleTriggerService simpleTriggerService;
    private final BlobTriggerService blobTriggerService;
    private final CronTriggerService cronTriggerService;

    public List<TriggerDTO> findAll() {
        List<QuartzTriggers> triggers = this.triggerRepository.findAll();
        return TriggerDTO.from(triggers);
    }

    public List<TriggerDTO> findByJobId(JobId jobId) {
        List<QuartzTriggers> triggers = this.triggerRepository.findById_SchedulerNameAndJobGroupAndJobName(jobId.getSchedulerName(), jobId.getJobGroup(), jobId.getJobName());
        return TriggerDTO.from(triggers);
    }

    public TriggerDTO findById(TriggerId triggerId) {
        QuartzTriggers trigger = this.triggerRepository.findById(triggerId)
                .orElseThrow(() -> new ServiceException("trigger is null triggerId : " + triggerId));

        return TriggerDTO.from(trigger);
    }

    public void deleteById(TriggerId triggerId) {
        TriggerDTO trigger = this.findById(triggerId);

        switch (trigger.getTriggerType()) {
            case SIMPLE:
                this.simpleTriggerService.deleteById(triggerId);
                break;
            case CRON:
                this.cronTriggerService.deleteById(triggerId);
                break;
            case BLOB:
                this.blobTriggerService.deleteById(triggerId);
                break;
            default:
                break;
        }

        this.triggerRepository.deleteById(triggerId);
    }
}
