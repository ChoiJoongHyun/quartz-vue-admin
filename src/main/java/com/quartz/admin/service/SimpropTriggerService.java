/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.QuartzSimpropTriggers;
import com.quartz.admin.repository.SimpropTriggerRepository;
import com.quartz.admin.service.dto.SimpropTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class SimpropTriggerService {

    private final SimpropTriggerRepository simpropTriggerRepository;

    public List<SimpropTriggerDTO> findAll() {
        List<QuartzSimpropTriggers> simpropTriggers = simpropTriggerRepository.findAll();
        return SimpropTriggerDTO.from(simpropTriggers);
    }
}
