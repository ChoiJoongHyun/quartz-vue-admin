/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.service;

import com.quartz.admin.controller.api.request.SimpleTriggerAddForm;
import com.quartz.admin.domain.JobId;
import com.quartz.admin.domain.QuartzSimpleTriggers;
import com.quartz.admin.domain.TriggerId;
import com.quartz.admin.repository.SimpleTriggerRepository;
import com.quartz.admin.repository.TriggerRepository;
import com.quartz.admin.service.dto.SimpleTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class SimpleTriggerService {

    private final TriggerRepository triggerRepository;
    private final SimpleTriggerRepository simpleTriggersRepository;

    public List<SimpleTriggerDTO> findAll() {
        List<QuartzSimpleTriggers> simpleTriggers = this.simpleTriggersRepository.findAll();
        return SimpleTriggerDTO.from(simpleTriggers);
    }

    public void save(JobId jobId, SimpleTriggerAddForm form) {
        QuartzSimpleTriggers simpleTriggers = form.toQuartzSimpleTriggers(jobId);

        triggerRepository.save(simpleTriggers.getTrigger());
        simpleTriggersRepository.save(simpleTriggers);
    }

    public void deleteById(TriggerId triggerId) {
        simpleTriggersRepository.deleteById(triggerId);
    }
}
