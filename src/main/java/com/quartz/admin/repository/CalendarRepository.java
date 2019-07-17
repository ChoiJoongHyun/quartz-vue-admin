/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.CalendarId;
import com.quartz.admin.domain.QuartzCalendars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<QuartzCalendars, CalendarId> {

}
