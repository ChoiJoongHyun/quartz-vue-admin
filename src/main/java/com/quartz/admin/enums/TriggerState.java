/**
 * Created by joonghyun on 2019-07-25
 */
package com.quartz.admin.enums;

/**
 * {@link org.quartz.impl.jdbcjobstore.Constants}
 * */
public enum TriggerState {
    WAITING,
    ACQUIRED,
    EXECUTING,
    COMPLETE,
    BLOCKED,
    ERROR,
    PAUSED,
    PAUSED_BLOCKED,
    DELETED
}
