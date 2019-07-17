/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.QuartzBlobTriggers;
import com.quartz.admin.domain.TriggerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlobTriggerRepository extends JpaRepository<QuartzBlobTriggers, TriggerId> {
}
