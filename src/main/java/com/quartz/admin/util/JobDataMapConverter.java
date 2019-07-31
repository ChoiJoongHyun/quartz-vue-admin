/**
 * Created by joonghyun on 2019-07-31
 */
package com.quartz.admin.util;

import lombok.experimental.UtilityClass;
import org.quartz.JobDataMap;

import java.util.Map;

@UtilityClass
public class JobDataMapConverter {

    public static JobDataMap toJobDataMap(Map<String, String> map) {
        return new JobDataMap(map);
    }
}
