/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service.dto;

import com.quartz.admin.domain.QuartzTriggers;
import com.quartz.admin.domain.TriggerId;
import com.quartz.admin.enums.TriggerState;
import com.quartz.admin.enums.TriggerType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.quartz.JobDataMap;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class TriggerDTO {

    private TriggerId id;
    private String jobName;
    private String jobGroup;
    private String description;
    private Long nextFireTime;
    private Long prevFireTime;
    private Long priority;
    private TriggerState triggerState;
    private TriggerType triggerType;
    private Long startTime;
    private Long endTime;
    private String calendarName;
    private Integer misfireInstr;
    private JobDataMap jobData;
    private JobDTO jobDetail;

    public static TriggerDTO from(QuartzTriggers triggers) {
        return TriggerDTO.builder()
                .id(triggers.getId())
                .jobName(triggers.getJobName())
                .jobGroup(triggers.getJobGroup())
                .description(triggers.getDescription())
                .nextFireTime(triggers.getNextFireTime())
                .prevFireTime(triggers.getPrevFireTime())
                .priority(triggers.getPriority())
                .triggerState(triggers.getTriggerState())
                .triggerType(triggers.getTriggerType())
                .startTime(triggers.getStartTime())
                .endTime(triggers.getEndTime())
                .calendarName(triggers.getCalendarName())
                .misfireInstr(triggers.getMisfireInstr())
                .jobData(triggers.getJobData())
                .jobDetail(JobDTO.from(triggers.getJobDetails()))
                .build();
    }

    public static List<TriggerDTO> from(List<QuartzTriggers> triggersList) {
        return triggersList.stream()
                .map(TriggerDTO::from)
                .collect(Collectors.toList());
    }
}
