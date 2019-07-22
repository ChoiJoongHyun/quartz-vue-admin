/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.api.request.CronTriggerFilter;
import com.quartz.admin.controller.path.ApiPath;
import com.quartz.admin.service.CronTriggerService;
import com.quartz.admin.service.dto.CronTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPath.CronTriggers.ROOT)
public class CronTriggerController {

    private final CronTriggerService cronTriggerService;

    @GetMapping
    public List<CronTriggerDTO> cronTriggerList(@Valid CronTriggerFilter request) {
        return this.cronTriggerService.findByFilter(request);
    }
}
