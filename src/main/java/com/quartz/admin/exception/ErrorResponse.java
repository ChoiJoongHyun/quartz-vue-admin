/**
 * Created by joonghyun on 2019-07-26
 */
package com.quartz.admin.exception;

import lombok.Getter;

public class ErrorResponse {

    @Getter
    private String errorMsg;

    public ErrorResponse(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
