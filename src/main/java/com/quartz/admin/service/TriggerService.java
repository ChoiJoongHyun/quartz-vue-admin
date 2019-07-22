/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.controller.api.request.TriggerFilter;
import com.quartz.admin.domain.QuartzTriggers;
import com.quartz.admin.repository.TriggerRepository;
import com.quartz.admin.service.dto.TriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class TriggerService {

    private final TriggerRepository triggerRepository;

    public List<TriggerDTO> findAll() {
        return TriggerDTO.from(this.triggerRepository.findAll());
    }

    public List<TriggerDTO> findByFilter(TriggerFilter filter) {
        if(StringUtils.isEmpty(filter.getJobGroup())) {
            return TriggerDTO.from(this.triggerRepository.findAll());
        }

        return TriggerDTO.from(this.triggerRepository.findByJobGroup(filter.getJobGroup()));
    }

    public List<String> findJobGroups() {
        List<QuartzTriggers> triggers = this.triggerRepository.findAll();

        return triggers.stream()
                .map(trigger -> trigger.getJobGroup())
                .distinct()
                .collect(Collectors.toList());
    }
}
