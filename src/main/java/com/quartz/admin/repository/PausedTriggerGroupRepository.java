/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.PausedTriggerGroupId;
import com.quartz.admin.domain.QuartzPausedTriggerGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PausedTriggerGroupRepository extends JpaRepository<QuartzPausedTriggerGroup, PausedTriggerGroupId> {
}
