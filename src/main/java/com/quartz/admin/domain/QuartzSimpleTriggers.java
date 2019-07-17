/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "QRTZ_SIMPLE_TRIGGERS")
public class QuartzSimpleTriggers implements Serializable {

    @EmbeddedId
    private TriggerId id;

    @Column(name = "REPEAT_COUNT")
    private Long repeatCount;

    @Column(name = "REPEAT_INTERVAL")
    private Long repeatInterval;

    @Column(name = "TIMES_TRIGGERED")
    private Long timesTriggered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "SCHED_NAME", referencedColumnName = "SCHED_NAME", insertable = false, updatable = false),
            @JoinColumn(name = "TRIGGER_NAME", referencedColumnName = "TRIGGER_NAME", insertable = false, updatable = false),
            @JoinColumn(name = "TRIGGER_GROUP", referencedColumnName = "TRIGGER_GROUP", insertable = false, updatable = false),
    })
    private QuartzTriggers trigger;
}
