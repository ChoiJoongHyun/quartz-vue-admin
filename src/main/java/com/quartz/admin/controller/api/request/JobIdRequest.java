/**
 * Created by joonghyun on 2019-07-23
 */
package com.quartz.admin.controller.api.request;

import com.quartz.admin.domain.JobId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter
public class JobIdRequest {
    private String schedulerName;
    private String jobGroup;
    private String jobName;

    public JobId toJobId() {
        return new JobId(schedulerName, jobGroup, jobName);
    }
}
