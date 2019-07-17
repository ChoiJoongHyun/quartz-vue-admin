/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.LockId;
import com.quartz.admin.domain.QuartzLocks;
import com.quartz.admin.repository.QuartzLockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class QuartzLockService {

    private final QuartzLockRepository quartzLockRepository;

    public List<LockId> findAll() {
        List<QuartzLocks> locks = quartzLockRepository.findAll();

        return locks.stream()
                .map(QuartzLocks::getId)
                .collect(Collectors.toList());
    }
}
