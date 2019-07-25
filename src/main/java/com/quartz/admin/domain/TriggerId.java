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
public class TriggerId implements Serializable {

    @Column(name="SCHED_NAME", nullable = false, length = 120)
    private String schedulerName;

    @Column(name="TRIGGER_GROUP", nullable = false, length = 200)
    private String triggerGroup;

    @Column(name="TRIGGER_NAME", nullable = false, length = 200)
    private String triggerName;

    public TriggerId(String schedulerName, String triggerGroup, String triggerName) {
        this.schedulerName = schedulerName;
        this.triggerGroup = triggerGroup;
        this.triggerName = triggerName;
    }

    @Override
    public String toString() {
        return "TriggerId{" +
                "schedulerName='" + schedulerName + '\'' +
                ", triggerGroup='" + triggerGroup + '\'' +
                ", triggerName='" + triggerName + '\'' +
                '}';
    }
}
