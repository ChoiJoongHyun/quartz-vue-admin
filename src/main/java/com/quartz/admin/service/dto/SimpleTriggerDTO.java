/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service.dto;

import com.quartz.admin.domain.QuartzSimpleTriggers;
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
public class SimpleTriggerDTO {

    private TriggerId id;
    private long repeatCount;
    private long repeatInterval;
    private long timesTriggered;

    private TriggerDTO trigger;

    public static SimpleTriggerDTO from(QuartzSimpleTriggers simpleTriggers) {

        TriggerDTO triggerDTO = TriggerDTO.from(simpleTriggers.getTrigger());

        return SimpleTriggerDTO.builder()
                .id(simpleTriggers.getId())
                .repeatCount(simpleTriggers.getHumanReadableRepeatCount())
                .repeatInterval(simpleTriggers.getRepeatInterval())
                .timesTriggered(simpleTriggers.getTimesTriggered())
                .trigger(triggerDTO)
                .build();
    }

    public static List<SimpleTriggerDTO> from(List<QuartzSimpleTriggers> simpleTriggersList) {
        return simpleTriggersList.stream()
                .map(SimpleTriggerDTO::from)
                .collect(Collectors.toList());
    }
}
