/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.QuartzCalendars;
import com.quartz.admin.repository.CalendarRepository;
import com.quartz.admin.service.dto.CalendarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CalendarService {

    private final CalendarRepository calendarsRepository;

    public List<CalendarDTO> findAll() {
        List<QuartzCalendars> calendars = calendarsRepository.findAll();
        return CalendarDTO.from(calendars);
    }
}
