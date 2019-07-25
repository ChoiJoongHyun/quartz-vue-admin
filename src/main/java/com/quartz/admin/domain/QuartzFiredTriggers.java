/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "QRTZ_FIRED_TRIGGERS")
public class QuartzFiredTriggers implements Serializable {

    @EmbeddedId
    private FiredTriggerId id;

    @Column(name = "TRIGGER_GROUP", nullable = false, length = 200)
    private String triggerGroup;

    @Column(name = "TRIGGER_NAME", nullable = false, length = 200)
    private String triggerName;

    @Column(name = "INSTANCE_NAME", nullable = false, length = 200)
    private String instanceName;

    @Column(name = "FIRED_TIME", nullable = false)
    private long firedTime;

    @Column(name = "SCHED_TIME", nullable = false)
    private long schedulerTime;

    @Column(name = "PRIORITY", nullable = false)
    private long priority;

    @Column(name = "STATE", nullable = false, length = 16)
    private String state;

    @Column(name = "JOB_NAME")
    private String jobName;

    @Column(name = "JOB_GROUP")
    private String jobGroup;

    @Column(name = "IS_NONCONCURRENT")
    private Boolean isNonConcurrent;

    @Column(name = "REQUESTS_RECOVERY")
    private Boolean requestsRecovery;
}
