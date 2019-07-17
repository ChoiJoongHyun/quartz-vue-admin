/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.LockId;
import com.quartz.admin.domain.QuartzLocks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartzLockRepository extends JpaRepository<QuartzLocks, LockId> {

}
