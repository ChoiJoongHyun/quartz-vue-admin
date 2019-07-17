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
public class LockId implements Serializable {

    @Column(name = "SCHED_NAME")
    private String schedulerName;

    @Column(name = "LOCK_NAME")
    private String lockName;

    public LockId(String schedulerName, String lockName) {
        this.schedulerName = schedulerName;
        this.lockName = lockName;
    }
}
