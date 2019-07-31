/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import com.quartz.admin.domain.converter.JobDataMapDomainConverter;
import com.quartz.admin.enums.TriggerState;
import com.quartz.admin.enums.TriggerType;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Entity
@Table(name = "QRTZ_TRIGGERS")
@Slf4j
public class QuartzTriggers implements Serializable {

    @EmbeddedId
    private TriggerId id;

    @Column(name = "JOB_GROUP", nullable = false, length = 200)
    private String jobGroup;

    @Column(name = "JOB_NAME", nullable = false, length = 200)
    private String jobName;

    @Column(name = "DESCRIPTION", length = 250)
    private String description;

    @Column(name = "NEXT_FIRE_TIME")
    private Long nextFireTime;

    @Column(name = "PREV_FIRE_TIME")
    private Long prevFireTime;

    @Column(name = "PRIORITY")
    private Long priority;

    @Column(name = "TRIGGER_STATE", nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    private TriggerState triggerState;

    @Column(name = "TRIGGER_TYPE", nullable = false, length = 8)
    @Enumerated(EnumType.STRING)
    private TriggerType triggerType;

    @Column(name = "START_TIME", nullable = false)
    private long startTime;

    @Column(name = "END_TIME")
    private Long endTime;

    @Column(name = "CALENDAR_NAME", length = 200)
    private String calendarName;

    @Column(name = "MISFIRE_INSTR")
    private Integer misfireInstr;

    @Convert(converter = JobDataMapDomainConverter.class)
    @Column(name = "JOB_DATA")
    @Lob
    private JobDataMap jobData;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumns({
            @JoinColumn(name = "SCHED_NAME", referencedColumnName = "SCHED_NAME", insertable = false, updatable = false),
            @JoinColumn(name = "JOB_GROUP", referencedColumnName = "JOB_GROUP", insertable = false, updatable = false),
            @JoinColumn(name = "JOB_NAME", referencedColumnName = "JOB_NAME", insertable = false, updatable = false)
    })
    private QuartzJobDetails jobDetails;
}
