/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.FiredTriggerId;
import com.quartz.admin.domain.QuartzFiredTriggers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiredTriggerRepository extends JpaRepository<QuartzFiredTriggers, FiredTriggerId> {
}
