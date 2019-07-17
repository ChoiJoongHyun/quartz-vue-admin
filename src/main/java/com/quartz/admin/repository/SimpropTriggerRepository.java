/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.QuartzSimpropTriggers;
import com.quartz.admin.domain.TriggerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpropTriggerRepository extends JpaRepository<QuartzSimpropTriggers, TriggerId> {
}
