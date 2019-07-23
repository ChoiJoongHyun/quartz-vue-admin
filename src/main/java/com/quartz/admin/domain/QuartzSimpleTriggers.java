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

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private QuartzTriggers trigger;
}
