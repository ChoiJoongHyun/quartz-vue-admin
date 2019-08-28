/**
 * Created by joonghyun on 2019-07-25
 */
package com.quartz.admin.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.ZoneId;

@UtilityClass
public class LocalDateTimeConverter {

    public static long toLongDefaultZero(LocalDateTime localDateTime) {
        return localDateTime == null ? 0L : localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static Long toLongDefaultNow(LocalDateTime localDateTime) {
        return localDateTime == null
                ? LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
                : localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
