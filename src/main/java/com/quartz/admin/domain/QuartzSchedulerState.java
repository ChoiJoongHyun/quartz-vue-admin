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
@Table(name = "QRTZ_SCHEDULER_STATE")
public class QuartzSchedulerState implements Serializable {

    @EmbeddedId
    private SchedulerStateId id;

    @Column(name = "LAST_CHECKIN_TIME", nullable = false)
    private long lastCheckinTime;

    @Column(name = "CHECKIN_INTERVAL", nullable = false)
    private long checkinInterval;
}
