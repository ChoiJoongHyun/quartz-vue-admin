/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.QuartzSchedulerState;
import com.quartz.admin.domain.SchedulerStateId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerStateRepository extends JpaRepository<QuartzSchedulerState, SchedulerStateId> {
}
