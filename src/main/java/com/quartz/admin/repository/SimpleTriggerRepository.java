/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.QuartzSimpleTriggers;
import com.quartz.admin.domain.TriggerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleTriggerRepository extends JpaRepository<QuartzSimpleTriggers, TriggerId> {

}
