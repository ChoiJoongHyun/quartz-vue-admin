/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Embeddable
public class PausedTriggerGrpsId implements Serializable {

    @Column(name = "SCHED_NAME")
    private String schedulerName;

    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;

    public PausedTriggerGrpsId(String schedulerName, String triggerGroup) {
        this.schedulerName = schedulerName;
        this.triggerGroup = triggerGroup;
    }
}
