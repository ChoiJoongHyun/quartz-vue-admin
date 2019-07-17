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

@EqualsAndHashCode(of = {"schedulerName", "triggerName", "triggerGroup"})
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Embeddable
public class CronTriggerId implements Serializable {

    @Column(name="SCHED_NAME")
    private String schedulerName;

    @Column(name="TRIGGER_NAME")
    private String triggerName;

    @Column(name="TRIGGER_GROUP")
    private String triggerGroup;

    public CronTriggerId(String schedulerName, String triggerName, String triggerGroup) {
        this.schedulerName = schedulerName;
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
    }
}
