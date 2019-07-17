/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.QuartzFiredTriggers;
import com.quartz.admin.repository.FiredTriggerRepository;
import com.quartz.admin.service.dto.FiredTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class FiredTriggerService {

    private final FiredTriggerRepository firedTriggerRepository;

    public List<FiredTriggerDTO> findAll() {
        List<QuartzFiredTriggers> firedTriggers = firedTriggerRepository.findAll();
        return FiredTriggerDTO.from(firedTriggers);
    }
}
