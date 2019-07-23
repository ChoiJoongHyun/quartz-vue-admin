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
@Table(name = "QRTZ_CRON_TRIGGERS")
public class QuartzCronTriggers implements Serializable {

    @EmbeddedId
    private TriggerId id;

    @Column(name = "CRON_EXPRESSION")
    private String cronExpression;

    @Column(name = "TIME_ZONE_ID")
    private String timeZoneId;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private QuartzTriggers trigger;
}
