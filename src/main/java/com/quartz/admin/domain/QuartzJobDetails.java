/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.quartz.JobDataMap;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "QRTZ_JOB_DETAILS")
public class QuartzJobDetails implements Serializable {

    @EmbeddedId
    private JobId id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "JOB_CLASS_NAME", nullable = false)
    private String jobClassName;

    @Column(name = "IS_DURABLE", nullable = false)
    private boolean durable;

    @Column(name = "IS_NONCONCURRENT", nullable = false)
    private boolean nonConcurrent;

    @Column(name = "IS_UPDATE_DATA", nullable = false)
    private boolean updateData;

    @Column(name = "REQUESTS_RECOVERY", nullable = false)
    private boolean requestsRecovery;

    @Column(name = "JOB_DATA")
    @Lob
    private JobDataMap jobData;
}
