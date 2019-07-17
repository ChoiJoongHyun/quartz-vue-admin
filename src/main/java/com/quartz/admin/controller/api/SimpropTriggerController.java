/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.service.SimpropTriggerService;
import com.quartz.admin.service.dto.SimpropTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/simprop/triggers")
public class SimpropTriggerController {

    private final SimpropTriggerService simpropTriggerService;

    @GetMapping
    public List<SimpropTriggerDTO> simpropTriggerList() {
        return simpropTriggerService.findAll();
    }
}
