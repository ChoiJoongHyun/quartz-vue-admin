/**
 * Created by joonghyun on 2019-07-22
 */
package com.quartz.admin.controller.path;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiPath {

    private static final String ROOT = "/api";

    public static final String JOB_ID = "/scheduler-names/{schedulerName}/job-groups/{jobGroup}/job-names/{jobName}";
    public static final String TRIGGER_ID = "/scheduler-names/{schedulerName}/trigger-groups/{triggerGroup}/trigger-names/{triggerName}";

    @UtilityClass
    public  class Triggers {
        public static final String ROOT = ApiPath.ROOT + "/triggers";
    }

    @UtilityClass
    public  class FiredTriggers {
        public static final String ROOT = ApiPath.ROOT + "/fired/triggers";
    }

    @UtilityClass
    public  class CronTriggers {
        public static final String ROOT = ApiPath.ROOT + "/cron/triggers";

        public static final String CRON_EXPRESSION_CHECK = "/cron-expression-check";
    }

    @UtilityClass
    public  class SimpleTriggers {
        public static final String ROOT = ApiPath.ROOT + "/simple/triggers";
    }

    @UtilityClass
    public  class BlobTriggers {
        public static final String ROOT = ApiPath.ROOT + "/blob/triggers";
    }

    @UtilityClass
    public  class Calendars {
        public static final String ROOT = ApiPath.ROOT + "/calendars";
    }

    @UtilityClass
    public class Jobs {
        public static final String ROOT = ApiPath.ROOT + "/jobs";
    }

    @UtilityClass
    public class PausedTriggerGroups {
        public static final String ROOT = ApiPath.ROOT + "/paused-trigger-groups";
    }

    @UtilityClass
    public class Locks {
        public static final String ROOT = ApiPath.ROOT + "/locks";
    }

    @UtilityClass
    public class SchedulerState {
        public static final String ROOT = ApiPath.ROOT + "/scheduler-state";
    }
}
