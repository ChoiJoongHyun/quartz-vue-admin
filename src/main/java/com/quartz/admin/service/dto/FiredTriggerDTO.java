/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service.dto;

import com.quartz.admin.domain.FiredTriggerId;
import com.quartz.admin.domain.QuartzFiredTriggers;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class FiredTriggerDTO {

    private FiredTriggerId id;
    private String triggerName;
    private String triggerGroup;
    private String instanceName;
    private Long firedTime;
    private Long schedulerTime;
    private Long priority;
    private String state;
    private String jobName;
    private String jobGroup;
    private Boolean isNonConcurrent;
    private Boolean requestsRecovery;

    public static FiredTriggerDTO from(QuartzFiredTriggers firedTriggers) {
        return FiredTriggerDTO.builder()
                .id(firedTriggers.getId())
                .triggerName(firedTriggers.getTriggerName())
                .triggerGroup(firedTriggers.getTriggerGroup())
                .instanceName(firedTriggers.getInstanceName())
                .firedTime(firedTriggers.getFiredTime())
                .schedulerTime(firedTriggers.getSchedulerTime())
                .priority(firedTriggers.getPriority())
                .state(firedTriggers.getState())
                .jobName(firedTriggers.getJobName())
                .jobGroup(firedTriggers.getJobGroup())
                .isNonConcurrent(firedTriggers.getIsNonConcurrent())
                .requestsRecovery(firedTriggers.getRequestsRecovery())
                .build();
    }

    public static List<FiredTriggerDTO> from(List<QuartzFiredTriggers> firedTriggersList) {
        return firedTriggersList.stream()
                .map(FiredTriggerDTO::from)
                .collect(Collectors.toList());
    }
}
