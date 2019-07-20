/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import com.quartz.admin.util.BlobConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "QRTZ_TRIGGERS")
public class QuartzTriggers implements Serializable {

    @EmbeddedId
    private TriggerId id;

    @Column(name = "JOB_NAME")
    private String jobName;

    @Column(name = "JOB_GROUP")
    private String jobGroup;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NEXT_FIRE_TIME")
    private Long nextFireTime;

    @Column(name = "PREV_FIRE_TIME")
    private Long prevFireTime;

    @Column(name = "PRIORITY")
    private Long priority;

    @Column(name = "TRIGGER_STATE")
    private String triggerState;

    @Column(name = "TRIGGER_TYPE")
    @Enumerated(EnumType.STRING)
    private TriggerType triggerType;

    @Column(name = "START_TIME")
    private Long startTime;

    @Column(name = "END_TIME")
    private Long endTime;

    @Column(name = "CALENDAR_NAME")
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
