/**
 * Created by joonghyun on 2019-07-26
 */
package com.quartz.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Slf4j
public class ExceptionAdvice {

    @ControllerAdvice(annotations = RestController.class)
    @Order(Ordered.HIGHEST_PRECEDENCE + 2)
    public static class ServerExceptionAdvice {

        @ExceptionHandler({ ServiceException.class, DomainException.class })
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ResponseBody
        public ErrorResponse serviceException(RuntimeException e) {
            return new ErrorResponse(e.getMessage());
        }

        @ExceptionHandler({Exception.class})
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ResponseBody
        public ErrorResponse exception(Exception e) {
            log.error("ServerExceptionAdvice exception...", e);
            return new ErrorResponse("unknown error");
        }
    }

    @ControllerAdvice(annotations = RestController.class)
    @Order(Ordered.HIGHEST_PRECEDENCE + 1)
    public static class ValidExceptionAdvice {

        /**
         * required query param bind exception
         * */
        @ExceptionHandler(BindException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ResponseBody
        public ErrorResponse bindException(BindException e) {
            String message = ExceptionAdvice.generateFieldErrorMessage(e);
            return new ErrorResponse(message);
        }

        /**
         * "@RequestBody" required = true
         * exception in case there is no content (body)
         * */
        @ExceptionHandler(HttpMessageNotReadableException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ResponseBody
        public ErrorResponse httpMessageNotReadableException() {
            return new ErrorResponse("request body is empty");
        }

        /**
         * required request body bind exception
         * */
        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ResponseBody
        public ErrorResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {
            BindingResult bindingResult = e.getBindingResult();
            String message = ExceptionAdvice.generateFieldErrorMessage(bindingResult);
            return new ErrorResponse(message);
        }
    }

    private static String generateFieldErrorMessage(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .map(FieldErrorMessage::new)
                .map(FieldErrorMessage::getPrettyFullMessage)
                .collect(Collectors.joining());
    }

    private static class FieldErrorMessage {

        private String defaultMessage;
        private String field;
        private Object rejectedValue;

        private FieldErrorMessage(FieldError fieldError) {
            this.defaultMessage = fieldError.getDefaultMessage();
            this.field = fieldError.getField();
            this.rejectedValue = fieldError.getRejectedValue();
        }

        private String getPrettyFullMessage() {
            return "[Field : " + this.field + ", "
                    + "Message : " + ObjectUtils.nullSafeToString(this.defaultMessage) + ", "
                    + "RejectedValue : " + ObjectUtils.nullSafeToString(this.rejectedValue) + "]";
        }
    }
}
