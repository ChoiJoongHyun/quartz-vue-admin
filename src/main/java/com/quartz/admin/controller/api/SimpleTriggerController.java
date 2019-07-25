/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.api.request.JobIdRequest;
import com.quartz.admin.controller.api.request.SimpleTriggerAddForm;
import com.quartz.admin.controller.path.ApiPath;
import com.quartz.admin.service.SimpleTriggerService;
import com.quartz.admin.service.dto.SimpleTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPath.SimpleTriggers.ROOT)
public class SimpleTriggerController {

    private final SimpleTriggerService simpleTriggerService;

    @GetMapping
    public List<SimpleTriggerDTO> simpleTriggerList() {
        return this.simpleTriggerService.findAll();
    }

    @PostMapping(ApiPath.JOB_ID)
    public void postSimpleTrigger(JobIdRequest jobIdRequest, @Valid @RequestBody SimpleTriggerAddForm form) {
        this.simpleTriggerService.save(jobIdRequest.toJobId(), form);
    }
}
