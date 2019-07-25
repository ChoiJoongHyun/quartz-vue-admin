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
    private Boolean isDurable;
    private Boolean isNonConcurrent;
    private Boolean isUpdateData;
    private Boolean requestsRecovery;
    private JobDataMap jobData;

    public static JobDTO from(QuartzJobDetails jobDetails) {
        return JobDTO.builder()
                .id(jobDetails.getId())
                .description(jobDetails.getDescription())
                .jobClassName(jobDetails.getJobClassName())
                .isDurable(jobDetails.isDurable())
                .isNonConcurrent(jobDetails.isNonConcurrent())
                .isUpdateData(jobDetails.isUpdateData())
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
