/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.QuartzTriggers;
import com.quartz.admin.domain.TriggerId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TriggerRepository extends JpaRepository<QuartzTriggers, TriggerId> {

    List<QuartzTriggers> findById_SchedulerNameAndJobGroupAndJobName(String schedulerName, String jobGroup, String jobName);

}
