/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.path.ApiPath;
import com.quartz.admin.service.BlobTriggerService;
import com.quartz.admin.service.dto.BlobTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPath.BlobTriggers.ROOT)
public class BlobTriggerController {

    private final BlobTriggerService blobTriggerService;

    @GetMapping
    public List<BlobTriggerDTO> blogTriggerList() {
        return blobTriggerService.findAll();
    }
}
