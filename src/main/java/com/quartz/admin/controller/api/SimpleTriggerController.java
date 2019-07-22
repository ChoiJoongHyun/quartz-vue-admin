/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.path.ApiPath;
import com.quartz.admin.service.SimpleTriggerService;
import com.quartz.admin.service.dto.SimpleTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
