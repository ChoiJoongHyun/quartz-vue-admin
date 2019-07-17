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

    @Column(name = "TRIGGER_NAME")
    private String triggerName;

    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;

    @Column(name = "INSTANCE_NAME")
    private String instanceName;

    @Column(name = "FIRED_TIME")
    private Long firedTime;

    @Column(name = "SCHED_TIME")
    private Long schedTime;

    @Column(name = "PRIORITY")
    private Long priority;

    @Column(name = "STATE")
    private String state;

    @Column(name = "JOB_NAME")
    private String jobName;

    @Column(name = "JOB_GROUP")
    private String jobGroup;

    @Column(name = "IS_NONCONCURRENT")
    private Boolean isNonconcurrent;

    @Column(name = "REQUESTS_RECOVERY")
    private Boolean requestsRecovery;
}
