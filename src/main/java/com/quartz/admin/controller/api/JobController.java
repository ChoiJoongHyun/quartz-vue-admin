/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.api.request.JobIdRequest;
import com.quartz.admin.controller.path.ApiPath;
import com.quartz.admin.service.JobService;
import com.quartz.admin.service.dto.JobDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPath.Jobs.ROOT)
public class JobController {

    private final JobService jobService;

    @GetMapping
    public List<JobDTO> getJobList() {
        return this.jobService.findAll();
    }

    @GetMapping(ApiPath.JOB_ID)
    public JobDTO getJob(JobIdRequest jobIdRequest) {
        return this.jobService.findById(jobIdRequest.toJobId());
    }

    @DeleteMapping(ApiPath.JOB_ID)
    public List<JobDTO> deleteJob(JobIdRequest jobIdRequest) {
        jobService.deleteJob(jobIdRequest.toJobId());
        return this.jobService.findAll();
    }
}
