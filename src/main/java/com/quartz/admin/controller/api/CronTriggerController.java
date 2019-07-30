/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.controller.api;

import com.quartz.admin.controller.api.request.CronExpressionForm;
import com.quartz.admin.controller.api.request.TriggerIdRequest;
import com.quartz.admin.controller.path.ApiPath;
import com.quartz.admin.domain.QuartzCronTriggers;
import com.quartz.admin.service.CronTriggerService;
import com.quartz.admin.service.dto.CronTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPath.CronTriggers.ROOT)
public class CronTriggerController {

    private final CronTriggerService cronTriggerService;

    @GetMapping
    public List<CronTriggerDTO> cronTriggerList() {
        return this.cronTriggerService.findAll();
    }

    @GetMapping(ApiPath.CronTriggers.CRON_EXPRESSION_CHECK)
    public String checkCronExpression(@Valid CronExpressionForm cronExpressionForm) {
        return cronTriggerService.checkCronExpression(cronExpressionForm.getCronExpression());
    }

    @PutMapping(ApiPath.TRIGGER_ID)
    public CronTriggerDTO putCronExpression(TriggerIdRequest triggerIdRequest,
                                                @Valid @RequestBody CronExpressionForm cronExpressionForm) {
        return this.cronTriggerService.updateCronTriggerExpression(triggerIdRequest.toTriggerId(), cronExpressionForm);
    }
}
