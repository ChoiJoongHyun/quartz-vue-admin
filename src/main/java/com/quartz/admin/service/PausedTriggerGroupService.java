/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.PausedTriggerGroupId;
import com.quartz.admin.domain.QuartzPausedTriggerGroup;
import com.quartz.admin.repository.PausedTriggerGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class PausedTriggerGroupService {

    private final PausedTriggerGroupRepository pausedTriggerGroupRepository;

    public List<PausedTriggerGroupId> findAll() {
        List<QuartzPausedTriggerGroup> pausedTriggerGroups = pausedTriggerGroupRepository.findAll();

        return pausedTriggerGroups.stream()
                .map(QuartzPausedTriggerGroup::getId)
                .collect(Collectors.toList());
    }
}
