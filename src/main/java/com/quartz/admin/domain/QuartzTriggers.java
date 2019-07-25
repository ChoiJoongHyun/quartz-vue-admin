/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import com.quartz.admin.util.BlobConverter;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Entity
@Table(name = "QRTZ_TRIGGERS")
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
    private String triggerState;

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
    private Long misfireInstr;

    @Column(name = "JOB_DATA")
    private Blob jobData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "SCHED_NAME", referencedColumnName = "SCHED_NAME", insertable = false, updatable = false),
            @JoinColumn(name = "JOB_NAME", referencedColumnName = "JOB_NAME", insertable = false, updatable = false),
            @JoinColumn(name = "JOB_GROUP", referencedColumnName = "JOB_GROUP", insertable = false, updatable = false),
    })
    private QuartzJobDetails jobDetails;

    public String getStrJobData() {
        if(this.jobData == null) {
            return null;
        }

        return BlobConverter.toString(this.jobData);
    }
}
