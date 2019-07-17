/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.JobId;
import com.quartz.admin.domain.QuartzJobDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDetailRepository extends JpaRepository<QuartzJobDetails, JobId> {
}
