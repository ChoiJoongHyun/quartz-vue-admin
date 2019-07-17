/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.QuartzCronTriggers;
import com.quartz.admin.domain.TriggerId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CronTriggerRepository extends JpaRepository<QuartzCronTriggers, TriggerId> {

    List<QuartzCronTriggers> findByTrigger_JobGroup(String jobGroup);
}
