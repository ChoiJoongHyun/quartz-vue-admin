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

@EqualsAndHashCode(of = {"schedulerName", "triggerGroup"})
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Embeddable
public class PausedTriggerGroupId implements Serializable {

    @Column(name = "SCHED_NAME", nullable = false, length = 120)
    private String schedulerName;

    @Column(name = "TRIGGER_GROUP", nullable = false, length = 200)
    private String triggerGroup;

    public PausedTriggerGroupId(String schedulerName, String triggerGroup) {
        this.schedulerName = schedulerName;
        this.triggerGroup = triggerGroup;
    }
}
