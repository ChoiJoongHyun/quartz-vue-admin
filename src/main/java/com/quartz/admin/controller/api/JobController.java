/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.domain.JobId;
import com.quartz.admin.service.JobService;
import com.quartz.admin.service.dto.JobDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    @GetMapping
    public List<JobDTO> getJobList() {
        return this.jobService.findAll();
    }

    @DeleteMapping("/scheduler-names/{schedulerName}/job-groups/{jobGroup}/job-names/{jobName}")
    public List<JobDTO> deleteJob(@PathVariable String schedulerName,
                          @PathVariable String jobGroup,
                          @PathVariable String jobName) {
        jobService.deleteJob(new JobId(schedulerName, jobGroup, jobName));
        return this.jobService.findAll();
    }
}
