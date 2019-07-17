/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.QuartzSimpleTriggers;
import com.quartz.admin.repository.SimpleTriggerRepository;
import com.quartz.admin.service.dto.SimpleTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class SimpleTriggerService {

    private final SimpleTriggerRepository simpleTriggersRepository;

    public List<SimpleTriggerDTO> findAll() {
        List<QuartzSimpleTriggers> simpleTriggers = this.simpleTriggersRepository.findAll();
        return SimpleTriggerDTO.from(simpleTriggers);
    }
}
