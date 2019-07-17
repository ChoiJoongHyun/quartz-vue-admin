/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.api.request.TriggerFilter;
import com.quartz.admin.service.TriggerService;
import com.quartz.admin.service.dto.TriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/triggers")
public class TriggerController {

    private final TriggerService triggerService;

    @GetMapping
    public List<TriggerDTO> triggerList(@Valid TriggerFilter filter) {
        return this.triggerService.findByFilter(filter);
    }

    @GetMapping("/group")
    public List<String> jobGroup() {
        return this.triggerService.findJobGroups();
    }
}
