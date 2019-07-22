/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.path.ApiPath;
import com.quartz.admin.service.CalendarService;
import com.quartz.admin.service.dto.CalendarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPath.Calendars.ROOT)
public class CalendarController {

    public final CalendarService calendarService;

    @GetMapping
    public List<CalendarDTO> calendarList() {
        return calendarService.findAll();
    }
}
