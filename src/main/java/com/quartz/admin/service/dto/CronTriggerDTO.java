/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service.dto;

import com.quartz.admin.domain.QuartzCronTriggers;
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
public class CronTriggerDTO {

    private TriggerId id;
    private String cronExpression;
    private String timeZoneId;

    private TriggerDTO trigger;

    public static CronTriggerDTO from(QuartzCronTriggers cronTriggers) {

        TriggerDTO triggerDTO = TriggerDTO.from(cronTriggers.getTrigger());

        return CronTriggerDTO.builder()
                .id(cronTriggers.getId())
                .cronExpression(cronTriggers.getCronExpression())
                .timeZoneId(cronTriggers.getTimeZoneId())
                .trigger(triggerDTO)
                .build();
    }

    public static List<CronTriggerDTO> from(List<QuartzCronTriggers> cronTriggersList) {
        return cronTriggersList.stream()
                .map(CronTriggerDTO::from)
                .collect(Collectors.toList());
    }
}
