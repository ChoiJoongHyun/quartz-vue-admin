/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.path.ApiPath;
import com.quartz.admin.service.FiredTriggerService;
import com.quartz.admin.service.dto.FiredTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPath.FiredTriggers.ROOT)
public class FiredTriggerController {

    private final FiredTriggerService firedTriggerService;

    @GetMapping
    public List<FiredTriggerDTO> firedTriggerList() {
        return this.firedTriggerService.findAll();
    }
}
