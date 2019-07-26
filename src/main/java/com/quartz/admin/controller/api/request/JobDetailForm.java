/**
 * Created by joonghyun on 2019-07-26
 */
package com.quartz.admin.controller.api.request;

import com.quartz.admin.domain.QuartzJobDetails;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class JobDetailForm {
    private boolean durable;
    private boolean nonConcurrent;
    private boolean requestsRecovery;
    private String description;

    public QuartzJobDetails toQuartzJobDetails() {
        return QuartzJobDetails.builder()
                .description(this.description)
                .durable(this.durable)
                .nonConcurrent(this.nonConcurrent)
                .requestsRecovery(this.requestsRecovery)
                .build();
    }
}
