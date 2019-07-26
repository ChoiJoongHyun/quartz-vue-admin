/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service.dto;

import com.quartz.admin.domain.JobId;
import com.quartz.admin.domain.QuartzJobDetails;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.quartz.JobDataMap;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class JobDTO {

    private JobId id;
    private String description;
    private String jobClassName;
    private boolean durable;
    private boolean nonConcurrent;
    private boolean updateData;
    private boolean requestsRecovery;
    private JobDataMap jobData;

    public static JobDTO from(QuartzJobDetails jobDetails) {
        return JobDTO.builder()
                .id(jobDetails.getId())
                .description(jobDetails.getDescription())
                .jobClassName(jobDetails.getJobClassName())
                .durable(jobDetails.isDurable())
                .nonConcurrent(jobDetails.isNonConcurrent())
                .updateData(jobDetails.isUpdateData())
                .requestsRecovery(jobDetails.isRequestsRecovery())
                .jobData(jobDetails.getJobData())
                .build();
    }

    public static List<JobDTO> from(List<QuartzJobDetails> jobDetailsList) {
        return jobDetailsList.stream()
                .map(JobDTO::from)
                .collect(Collectors.toList());
    }
}
