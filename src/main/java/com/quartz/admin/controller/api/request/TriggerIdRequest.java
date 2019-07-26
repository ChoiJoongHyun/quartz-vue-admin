/**
 * Created by joonghyun on 2019-07-25
 */
package com.quartz.admin.controller.api.request;

import com.quartz.admin.domain.TriggerId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter
public class TriggerIdRequest {
    private String schedulerName;
    private String triggerGroup;
    private String triggerName;

    public TriggerId toTriggerId() {
        return new TriggerId(schedulerName, triggerGroup, triggerName);
    }
}
