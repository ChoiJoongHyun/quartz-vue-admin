/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import com.quartz.admin.exception.DomainException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.quartz.CronExpression;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "QRTZ_CRON_TRIGGERS")
public class QuartzCronTriggers implements Serializable {

    @EmbeddedId
    private TriggerId id;

    @Column(name = "CRON_EXPRESSION", nullable = false, length = 200)
    private String cronExpression;

    @Column(name = "TIME_ZONE_ID", length = 80)
    private String timeZoneId;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @PrimaryKeyJoinColumn
    private QuartzTriggers trigger;

    public QuartzCronTriggers updateCronExpression(String updateCronExpression) {
        QuartzCronTriggers.validCronExpression(updateCronExpression);
        this.cronExpression = updateCronExpression;
        return this;
    }

    public static void validCronExpression(String cronExpression) {
        if(! isValidCronExpression(cronExpression)) {
            throw new DomainException("cron expression valid error... updateCronExpression : " + cronExpression);
        }
    }

    public static boolean isValidCronExpression(String cronExpression) {
        return CronExpression.isValidExpression(cronExpression);
    }
}
