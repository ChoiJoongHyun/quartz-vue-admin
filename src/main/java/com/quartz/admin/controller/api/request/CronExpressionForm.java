/**
 * Created by joonghyun on 2019-07-30
 */
package com.quartz.admin.controller.api.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class CronExpressionForm {

    @NotBlank
    private String cronExpression;
}
