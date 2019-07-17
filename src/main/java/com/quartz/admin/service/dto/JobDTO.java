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

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class JobDTO {

    private JobId id;
    private String description;
    private String jobClassName;
    private Boolean isDurable;
    private Boolean isNonConcurrent;
    private Boolean isUpdateData;
    private Boolean requestsRecovery;
    private String jobData;

    public static JobDTO from(QuartzJobDetails jobDetails) {
        return JobDTO.builder()
                .id(jobDetails.getId())
                .description(jobDetails.getDescription())
                .jobClassName(jobDetails.getJobClassName())
                .isDurable(jobDetails.getIsDurable())
                .isNonConcurrent(jobDetails.getIsNonConcurrent())
                .isUpdateData(jobDetails.getIsUpdateData())
                .requestsRecovery(jobDetails.getRequestsRecovery())
                .jobData(jobDetails.getJobData())
                .build();
    }

    public static List<JobDTO> from(List<QuartzJobDetails> jobDetailsList) {
        return jobDetailsList.stream()
                .map(JobDTO::from)
                .collect(Collectors.toList());
    }
}
