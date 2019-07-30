/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.service;

import com.quartz.admin.controller.api.request.CronExpressionForm;
import com.quartz.admin.domain.QuartzCronTriggers;
import com.quartz.admin.domain.TriggerId;
import com.quartz.admin.exception.ServiceException;
import com.quartz.admin.repository.CronTriggerRepository;
import com.quartz.admin.service.dto.CronTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CronTriggerService {

    private final CronTriggerRepository cronTriggerRepository;

    public List<CronTriggerDTO> findAll() {
        List<QuartzCronTriggers> cronTriggers = this.cronTriggerRepository.findAll();
        return CronTriggerDTO.from(cronTriggers);
    }

    public void deleteById(TriggerId triggerId) {
        cronTriggerRepository.deleteById(triggerId);
    }

    public QuartzCronTriggers updateCronTriggerExpression(TriggerId triggerId, CronExpressionForm cronExpressionForm) {
        QuartzCronTriggers cronTrigger = this.cronTriggerRepository.findById(triggerId)
                .orElseThrow(() -> new ServiceException("trigger is null triggerId : " + triggerId));

        cronTrigger.updateCronExpression(cronExpressionForm.getCronExpression());
        return cronTrigger;
    }

    public String checkCronExpression(String cronExpression) {
        QuartzCronTriggers.validCronExpression(cronExpression);
        return cronExpression;
    }
}
