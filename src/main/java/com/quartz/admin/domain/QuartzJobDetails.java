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
@Table(name = "QRTZ_JOB_DETAILS")
public class QuartzJobDetails implements Serializable {

    @EmbeddedId
    private JobId id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "JOB_CLASS_NAME")
    private String jobClassName;

    @Column(name = "IS_DURABLE")
    private Boolean isDurable;

    @Column(name = "IS_NONCONCURRENT")
    private Boolean isNonConcurrent;

    @Column(name = "IS_UPDATE_DATA")
    private Boolean isUpdateData;

    @Column(name = "REQUESTS_RECOVERY")
    private Boolean requestsRecovery;

    @Column(name = "JOB_DATA")
    private String jobData;
}
