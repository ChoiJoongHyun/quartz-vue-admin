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

@EqualsAndHashCode(of = {"schedulerName", "entryId"})
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Embeddable
public class FiredTriggerId implements Serializable {

    @Column(name = "SCHED_NAME", nullable = false, length = 120)
    private String schedulerName;

    @Column(name = "ENTRY_ID", nullable = false, length = 95)
    private String entryId;

    public FiredTriggerId(String schedulerName, String entryId) {
        this.schedulerName = schedulerName;
        this.entryId = entryId;
    }
}
