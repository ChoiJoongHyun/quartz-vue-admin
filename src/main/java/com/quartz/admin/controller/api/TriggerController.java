/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.api.request.JobIdRequest;
import com.quartz.admin.controller.api.request.TriggerIdRequest;
import com.quartz.admin.controller.path.ApiPath;
import com.quartz.admin.service.TriggerService;
import com.quartz.admin.service.dto.TriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(ApiPath.TRIGGER_ID)
    public TriggerDTO trigger(TriggerIdRequest triggerIdRequest) {
        return this.triggerService.findById(triggerIdRequest.toTriggerId());
    }

    @GetMapping(ApiPath.JOB_ID)
    public List<TriggerDTO> triggerListByJobId(JobIdRequest jobIdRequest) {
        return this.triggerService.findByJobId(jobIdRequest.toJobId());
    }

    @DeleteMapping(ApiPath.TRIGGER_ID)
    public void deleteTrigger(TriggerIdRequest triggerIdRequest) {
        this.triggerService.deleteById(triggerIdRequest.toTriggerId());
    }
}
