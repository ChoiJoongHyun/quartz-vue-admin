/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.path.ApiPath;
import com.quartz.admin.domain.JobId;
import com.quartz.admin.service.TriggerService;
import com.quartz.admin.service.dto.TriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPath.Triggers.ROOT)
public class TriggerController {

    private final TriggerService triggerService;

    @GetMapping
    public List<TriggerDTO> triggerList() {
        return this.triggerService.findAll();
    }

    @GetMapping(ApiPath.JOB_ID)
    public List<TriggerDTO> triggerListByJobId(@PathVariable String schedulerName,
                                               @PathVariable String jobGroup,
                                               @PathVariable String jobName) {
        return this.triggerService.findByJobId(new JobId(schedulerName, jobGroup, jobName));
    }
}
