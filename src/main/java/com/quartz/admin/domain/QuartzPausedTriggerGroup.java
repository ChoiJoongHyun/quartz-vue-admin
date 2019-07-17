/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "QRTZ_PAUSED_TRIGGER_GRPS")
public class QuartzPausedTriggerGroup implements Serializable {

    @EmbeddedId
    private PausedTriggerGroupId id;
}
