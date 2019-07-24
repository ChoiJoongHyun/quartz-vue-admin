/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.service;

import com.quartz.admin.controller.api.request.SimpleTriggerAddForm;
import com.quartz.admin.domain.JobId;
import com.quartz.admin.domain.QuartzSimpleTriggers;
import com.quartz.admin.repository.SimpleTriggerRepository;
import com.quartz.admin.service.dto.SimpleTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.quartz.JobDataMap;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.DateBuilder.*;

@RequiredArgsConstructor
@Service
@Transactional
public class SimpleTriggerService {

    private final SimpleTriggerRepository simpleTriggersRepository;

    public List<SimpleTriggerDTO> findAll() {
        List<QuartzSimpleTriggers> simpleTriggers = this.simpleTriggersRepository.findAll();
        return SimpleTriggerDTO.from(simpleTriggers);
    }

    public void save(SimpleTriggerAddForm form) {
        SimpleTriggerImpl simpleTrigger = (SimpleTriggerImpl) simpleSchedule().withIntervalInHours(1)
                .build();


        Object obj = new Object();
        JobDataMap jobDataMap = new JobDataMap(Collections.singletonMap("aa", obj));

    }
}
