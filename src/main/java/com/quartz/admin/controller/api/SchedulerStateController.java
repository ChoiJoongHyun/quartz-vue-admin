/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.service.SchedulerStateService;
import com.quartz.admin.service.dto.SchedulerStateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/scheduler-state")
public class SchedulerStateController {

    private final SchedulerStateService schedulerStateService;

    @GetMapping
    public List<SchedulerStateDTO> schedulerStateList() {
        return this.schedulerStateService.findAll();
    }
}
