/**
 * Created by joonghyun on 2019-07-23
 */
package com.quartz.admin.controller.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.quartz.admin.domain.JobId;
import com.quartz.admin.domain.QuartzSimpleTriggers;
import com.quartz.admin.domain.QuartzTriggers;
import com.quartz.admin.domain.TriggerId;
import com.quartz.admin.enums.RepeatIntervalType;
import com.quartz.admin.enums.TriggerState;
import com.quartz.admin.enums.TriggerType;
import com.quartz.admin.util.LocalDateTimeConverter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.quartz.JobDataMap;
import org.quartz.Trigger;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class SimpleTriggerAddForm {

    @NotBlank
    private String triggerGroup;
    @NotBlank
    private String triggerName;
    private String description;
    private long priority;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime startTime = LocalDateTime.now();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime endTime;
    private long repeatCount;
    private RepeatIntervalType repeatIntervalType;
    private long repeatInterval;
    private List<JobData> jobDataList = new ArrayList<>();

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Setter
    @Getter
    public static class JobData{
        private String key;
        private String value;

        public boolean isEmpty() {
            return StringUtils.isEmpty(this.key) || StringUtils.isEmpty(this.value);
        }
    }

    private JobDataMap getJobDataMap() {
        JobDataMap jobDataMap = new JobDataMap();

        for(JobData jobData : this.jobDataList) {
            if(! jobData.isEmpty()) {
                jobDataMap.put(jobData.getKey(), jobData.getValue());
            }
        }

        return jobDataMap;
    }

    public QuartzSimpleTriggers toQuartzSimpleTriggers(JobId jobId) {
        QuartzTriggers trigger = QuartzTriggers.builder()
                .id(new TriggerId(jobId.getSchedulerName(), this.triggerGroup, this.triggerName))
                .jobGroup(jobId.getJobGroup())
                .jobName(jobId.getJobName())
                .description(this.description)
                .priority(this.priority)
                .triggerState(TriggerState.WAITING)
                .triggerType(TriggerType.SIMPLE)
                .misfireInstr(Trigger.MISFIRE_INSTRUCTION_SMART_POLICY)
                .startTime(LocalDateTimeConverter.toLongDefaultNow(this.startTime))
                .nextFireTime(LocalDateTimeConverter.toLongDefaultNow(this.startTime))  //nextFireTime is the same as startTime
                .endTime(LocalDateTimeConverter.toLong(this.endTime))
                .jobData(getJobDataMap())
                .build();

        QuartzSimpleTriggers simpleTrigger = QuartzSimpleTriggers.builder()
                .id(trigger.getId())
                .repeatCount(this.repeatCount - 1)
                .repeatInterval(this.repeatIntervalType.getMillisecond(this.repeatInterval))
                .trigger(trigger)
                .build();

        return simpleTrigger;
    }
}
