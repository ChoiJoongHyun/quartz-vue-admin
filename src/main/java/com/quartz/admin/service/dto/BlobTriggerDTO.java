/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service.dto;

import com.quartz.admin.domain.QuartzBlobTriggers;
import com.quartz.admin.domain.TriggerId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class BlobTriggerDTO {

    private TriggerId id;
    private String blobData;
    private TriggerDTO trigger;

    public static BlobTriggerDTO from(QuartzBlobTriggers blobTriggers) {
        return BlobTriggerDTO.builder()
                .id(blobTriggers.getId())
                .blobData(blobTriggers.getBlobData())
                .trigger(TriggerDTO.from(blobTriggers.getTrigger()))
                .build();
    }

    public static List<BlobTriggerDTO> from(List<QuartzBlobTriggers> blobTriggersList) {
        return blobTriggersList.stream()
                .map(BlobTriggerDTO::from)
                .collect(Collectors.toList());
    }
}
