/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.QuartzCronTriggers;
import com.quartz.admin.domain.TriggerId;
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
}
