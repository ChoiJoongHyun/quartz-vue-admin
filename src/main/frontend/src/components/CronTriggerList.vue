<template>

  <div>
    <div>
      <!--TODO refresh btn-->
    </div>

    <div>
      <el-table :data="cronTriggerList" style="width: 100%" size="mini">

        <el-table-column prop="id.schedulerName" label="SchedulerName" sortable>
        </el-table-column>

        <el-table-column prop="id.triggerGroup" label="TriggerGroup" sortable>
        </el-table-column>

        <el-table-column prop="id.triggerName" label="TriggerName" sortable>
        </el-table-column>

        <el-table-column prop="trigger.jobGroup" label="JobGroup" sortable>
        </el-table-column>

        <el-table-column prop="trigger.jobName" label="JobName" sortable>
        </el-table-column>

        <el-table-column prop="cronExpression" label="CronExpression">
        </el-table-column>

        <el-table-column prop="timeZoneId" label="TimeZoneId">
        </el-table-column>







        <el-table-column label="PrevFireTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.trigger.prevFireTime | dateformatByLong }}
          </template>
        </el-table-column>

        <el-table-column label="NextFireTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.trigger.nextFireTime | dateformatByLong }}
          </template>
        </el-table-column>

        <el-table-column label="StartTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.trigger.startTime | dateformatByLong }}
          </template>
        </el-table-column>

        <el-table-column label="EndTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.trigger.endTime | dateformatByLong }}
          </template>
        </el-table-column>

        <el-table-column prop="trigger.triggerState" label="TriggerState" sortable>
        </el-table-column>

      </el-table>
    </div>

  </div>

</template>

<script>
  import CronTriggerAdapter from '../adapter/cronTriggerAdapter';

  export default {
    name: "CronTriggerList",

    data() {
      return {
        /* jobList example data
        * [{
            "id": {
              "schedulerName": "scheduler-name-01",
              "triggerName": "trigger-name-01",
              "triggerGroup": "trigger-group-01"
            },
            "cronExpression": "0 0 0 1/1 * ? *",
            "timeZoneId": "Asia/Seoul",
            "trigger": {
              "id": {
                "schedulerName": "scheduler-name-01",
                "triggerName": "trigger-name-01",
                "triggerGroup": "trigger-group-01"
              },
              "jobName": "job-name-01",
              "jobGroup": "job-group-01",
              "description": "description",
              "nextFireTime": 1530543600000,
              "prevFireTime": -1,
              "priority": 0,
              "triggerState": "WAITING",
              "triggerType": "CRON",
              "startTime": 1530543600000,
              "endTime": 0,
              "calendarName": null,
              "misfireInstr": 0,
              "jobData": null,
              "jobDetail": {
                "id": {
                  "schedulerName": "scheduler-name-01",
                  "jobName": "job-name-01",
                  "jobGroup": "job-group-01"
                },
                "description": "detail-description",
                "jobClassName": "com.zum.autoconfigure.scheduler.DefaultQuartzJob",
                "isDurable": true,
                "isNonConcurrent": true,
                "isUpdateData": true,
                "requestsRecovery": false,
                "jobData": "job_data_1"
              }
            }
          }]
        * */
        cronTriggerList: [],
      }
    },

    methods: {

      setCronTriggerList() {
        CronTriggerAdapter.getCronTriggerList().then((res) => {
          this.cronTriggerList = res;
        });
      }
    },

    created() {
      this.setCronTriggerList();
    },

    components: {

    }
  }
</script>

<style scoped>

</style>
