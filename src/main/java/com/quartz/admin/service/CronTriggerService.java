/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.service;

import com.quartz.admin.controller.api.request.CronTriggerFilter;
import com.quartz.admin.domain.QuartzCronTriggers;
import com.quartz.admin.repository.CronTriggerRepository;
import com.quartz.admin.service.dto.CronTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class CronTriggerService {

    private final CronTriggerRepository cronTriggerRepository;

    public List<CronTriggerDTO> findByFilter(final CronTriggerFilter filter) {
        if(StringUtils.isEmpty(filter.getJobGroup())) {
            List<QuartzCronTriggers> cronTriggers = this.cronTriggerRepository.findAll();
            return CronTriggerDTO.from(cronTriggers);
        }

        List<QuartzCronTriggers> cronTriggers = this.cronTriggerRepository.findByTrigger_JobGroup(filter.getJobGroup());
        return CronTriggerDTO.from(cronTriggers);
    }

    public List<String> findJobGroups() {
        List<QuartzCronTriggers> cronTriggers = this.cronTriggerRepository.findAll();

        return cronTriggers.stream()
                .map(trigger -> trigger.getTrigger().getJobGroup())
                .distinct()
                .collect(Collectors.toList());
    }
}
