/**
 * Created by joonghyun on 2019-07-25
 */
package com.quartz.admin.enums;

public enum RepeatIntervalType {

    MILLISECOND(1L),
    SECOND(1000L),
    MINUTE(60L * 1000L),
    HOUR(60L * 60L * 1000L);

    private long millisecond;

    RepeatIntervalType(long millisecond) {
        this.millisecond = millisecond;
    }

    public long getMillisecond(long repeatInterval) {
        return this.millisecond * repeatInterval;
    }
}
