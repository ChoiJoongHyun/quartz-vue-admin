/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service.dto;

import com.quartz.admin.domain.QuartzSchedulerState;
import com.quartz.admin.domain.SchedulerStateId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class SchedulerStateDTO {

    private SchedulerStateId id;
    private Long lastCheckinTime;
    private Long checkinInterval;

    public static SchedulerStateDTO from(QuartzSchedulerState schedulerState) {
        return SchedulerStateDTO.builder()
                .id(schedulerState.getId())
                .lastCheckinTime(schedulerState.getLastCheckinTime())
                .checkinInterval(schedulerState.getCheckinInterval())
                .build();
    }

    public static List<SchedulerStateDTO> from(List<QuartzSchedulerState> schedulerStateList) {
        return schedulerStateList.stream()
                .map(SchedulerStateDTO::from)
                .collect(Collectors.toList());
    }
}
