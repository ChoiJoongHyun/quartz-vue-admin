/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Entity
@Table(name = "QRTZ_SIMPLE_TRIGGERS")
public class QuartzSimpleTriggers implements Serializable {

    @EmbeddedId
    private TriggerId id;

    @Column(name = "REPEAT_COUNT", nullable = false)
    private Long repeatCount;

    @Column(name = "REPEAT_INTERVAL", nullable = false)
    private Long repeatInterval;

    @Column(name = "TIMES_TRIGGERED", nullable = false)
    private Long timesTriggered;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @PrimaryKeyJoinColumn
    private QuartzTriggers trigger;
}
