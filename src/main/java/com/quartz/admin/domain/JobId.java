/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode(of = {"schedulerName", "jobName", "jobGroup"})
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Embeddable
public class JobId implements Serializable {

    @Column(name = "SCHED_NAME", nullable = false, length = 120)
    private String schedulerName;

    @Column(name = "JOB_GROUP", nullable = false, length = 200)
    private String jobGroup;

    @Column(name = "JOB_NAME", nullable = false, length = 200)
    private String jobName;

    public JobId(String schedulerName, String jobGroup, String jobName) {
        this.schedulerName = schedulerName;
        this.jobGroup = jobGroup;
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "JobId{" +
                "schedulerName='" + schedulerName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                '}';
    }
}
