/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service.dto;

import com.quartz.admin.domain.CalendarId;
import com.quartz.admin.domain.QuartzCalendars;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class CalendarDTO {

    private CalendarId id;
    private String calendar;

    public static CalendarDTO from(QuartzCalendars calendars) {
        return CalendarDTO.builder()
                .id(calendars.getId())
                .calendar(calendars.getCalendar())
                .build();
    }

    public static List<CalendarDTO> from(List<QuartzCalendars> calendarsList) {
        return calendarsList.stream()
                .map(CalendarDTO::from)
                .collect(Collectors.toList());
    }
}
