/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.path.ApiPath;
import com.quartz.admin.domain.PausedTriggerGroupId;
import com.quartz.admin.service.PausedTriggerGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPath.PausedTriggerGroups.ROOT)
public class PausedTriggerGroupController {

    private final PausedTriggerGroupService pausedTriggerGroupService;

    @GetMapping
    public List<PausedTriggerGroupId> pausedTriggerGroupList() {
        return pausedTriggerGroupService.findAll();
    }
}
