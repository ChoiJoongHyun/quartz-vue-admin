<template>
  <div>
    <el-form ref="form" :model="trigger" size="mini" label-width="140px">
      <el-form-item label="SchedulerName">
        <el-input v-model="trigger.id.schedulerName" disabled></el-input>
      </el-form-item>

      <el-form-item label="TriggerGroup">
        <el-input v-model="trigger.id.triggerGroup" disabled></el-input>
      </el-form-item>

      <el-form-item label="TriggerName">
        <el-input v-model="trigger.id.triggerName" disabled></el-input>
      </el-form-item>

      <el-form-item label="JobGroup">
        <el-input v-model="trigger.jobGroup" disabled></el-input>
      </el-form-item>

      <el-form-item label="JobName">
        <el-input v-model="trigger.jobName" disabled></el-input>
      </el-form-item>

      <el-form-item label="StartTime">
        <span class="trigger-detail-value">
          {{ trigger.startTime | dateformatByLong }}
        </span>
      </el-form-item>

      <el-form-item label="EndTime">
        <span class="trigger-detail-value">
          {{ trigger.endTime | dateformatByLong }}
        </span>
      </el-form-item>

      <el-form-item label="PrevFireTime">
        <span class="trigger-detail-value">
          {{ trigger.prevFireTime | dateformatByLong }}
        </span>
      </el-form-item>

      <el-form-item label="NextFireTime">
        <span class="trigger-detail-value">
          {{ trigger.nextFireTime | dateformatByLong }}
        </span>
      </el-form-item>

      <el-form-item label="Priority">
        <el-input v-model="trigger.priority" disabled></el-input>
      </el-form-item>

      <el-form-item label="TriggerState">
        <el-input v-model="trigger.triggerState" disabled></el-input>
      </el-form-item>

      <el-form-item label="TriggerType">
        <el-input v-model="trigger.triggerType" disabled></el-input>
      </el-form-item>

      <el-form-item label="MisfireInstr">
        <el-input v-model="trigger.misfireInstr" disabled></el-input>
      </el-form-item>

      <el-form-item label="CalendarName">
        <el-input v-model="trigger.calendarName" disabled></el-input>
      </el-form-item>

      <el-form-item label="Description">
        <el-input type="textarea" v-model="trigger.description" disabled></el-input>
      </el-form-item>

      <el-form-item label="JobData">
        <pre>{{trigger.jobData}}</pre>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import TriggerAdapter from '../adapter/triggerAdapter';

  export default {
    name: "TriggerDetail",

    props: {
      triggerId: {
        type: Object,
        required: true
      }
    },

    data() {
      return {
        /*
        * {
            "id": {
              "schedulerName": "scheduler-name-01",
              "triggerGroup": "trigger-group-01",
              "triggerName": "trigger-name-01"
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
              "durable": true,
              "nonConcurrent": true,
              "updateData": true,
              "requestsRecovery": false,
              "jobData": null
            }
          }
        * */
        trigger: {
          id: {}
        }
      }
    },

    methods: {
      setTrigger() {
        TriggerAdapter.getTrigger(this.triggerId)
          .then((res) => {
            this.trigger = res;
          });
      }
    },

    created() {
      this.setTrigger();
    }
  }
</script>

<style scoped>

  .trigger-detail-value {
    background-color: #F5F7FA;
    color: #909399;
  }
</style>
