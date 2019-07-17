/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.domain.LockId;
import com.quartz.admin.service.QuartzLockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/locks")
public class QuartzLockController {

    private final QuartzLockService quartzLockService;

    @GetMapping
    public List<LockId> lockList() {
        return quartzLockService.findAll();
    }
}
