/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.QuartzSchedulerState;
import com.quartz.admin.repository.SchedulerStateRepository;
import com.quartz.admin.service.dto.SchedulerStateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class SchedulerStateService {

    private final SchedulerStateRepository schedulerStateRepository;

    public List<SchedulerStateDTO> findAll() {
        List<QuartzSchedulerState> schedulerStates = schedulerStateRepository.findAll();
        return SchedulerStateDTO.from(schedulerStates);
    }
}
