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

        <el-table-column label="CronExpression" width="200">
          <template slot-scope="scope">
            <div>
              <span style="margin-right: 10px">
                {{ scope.row.cronExpression }}
              </span>
              <el-button type="primary" icon="el-icon-edit" size="mini" circle @click="showUpdateCronExpression(scope.row)"></el-button>
            </div>
          </template>
        </el-table-column>

        <el-table-column prop="timeZoneId" label="TimeZoneId" width="90">
        </el-table-column>

        <el-table-column label="PrevFireTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.trigger.prevFireTime | dateByLong }} <br> {{ scope.row.trigger.prevFireTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column label="NextFireTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.trigger.nextFireTime | dateByLong }} <br> {{ scope.row.trigger.nextFireTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column label="StartTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.trigger.startTime | dateByLong }} <br> {{ scope.row.trigger.startTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column label="EndTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.trigger.endTime | dateByLong }} <br> {{ scope.row.trigger.endTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column prop="trigger.triggerState" label="TriggerState" sortable>
        </el-table-column>

        <el-table-column label="Detail" width="70">
          <template slot-scope="scope">
            <el-button type="info"
                       icon="el-icon-document"
                       size="mini"
                       @click="showDetailTrigger(scope.row)"
                       circle></el-button>
          </template>
        </el-table-column>

        <el-table-column label="Delete" width="70">
          <template slot-scope="scope">
            <el-button type="danger"
                       icon="el-icon-delete"
                       size="mini"
                       @click="deleteCronTrigger(scope.row)"
                       circle></el-button>
          </template>
        </el-table-column>

      </el-table>
    </div>

    <template>
      <el-dialog title="Trigger Detail"
                 width="35%"
                 align="left"
                 :visible.sync="detailDialogVisible"
                 :before-close="cancelDialog">

        <TriggerDetail v-if="detailDialogVisible"
                       :trigger-id="selectedTriggerId">
        </TriggerDetail>

      </el-dialog>
    </template>

    <template>
      <el-dialog title="Update Cron Expression"
                 :visible.sync="cronExpressionUpdateDialogVisible"
                 width="30%"
                 :before-close="cancelDialog">

        <el-input style="width: 80%; margin-right: 15px" size="mini" placeholder="Please input"
                  v-model="cronExpression"></el-input>
        <el-button style="width: 15%;" size="mini" type="success" plain @click="checkCronExpression">Check</el-button>

        <el-button type="text" @click="openCronMaker">http://www.cronmaker.com/</el-button>

        <span slot="footer" class="dialog-footer">
          <el-button size="mini" @click="cancelDialog">Cancel</el-button>
          <el-button size="mini" type="primary" @click="updateCronExpression">Confirm</el-button>
        </span>
      </el-dialog>
    </template>
  </div>

</template>

<script>

  import TriggerAdapter from '../adapter/triggerAdapter';
  import CronTriggerAdapter from '../adapter/cronTriggerAdapter';
  import TriggerDetail from './TriggerDetail';

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
                "durable": true,
                "nonConcurrent": true,
                "updateData": true,
                "requestsRecovery": false,
                "jobData": "job_data_1"
              }
            }
          }]
        * */
        cronTriggerList: [],
        selectedTriggerId: {},
        detailDialogVisible: false,
        cronExpressionUpdateDialogVisible: false,
        cronExpression: undefined
      }
    },

    methods: {

      setCronTriggerList() {
        CronTriggerAdapter.getCronTriggerList()
          .then((res) => this.cronTriggerList = res);
      },

      showDetailTrigger(row) {
        this.detailDialogVisible = true;
        this.selectedTriggerId = row.id;
      },

      showUpdateCronExpression(row) {
        this.cronExpressionUpdateDialogVisible = true;
        this.selectedTriggerId = row.id;
      },

      checkCronExpression() {
        CronTriggerAdapter.checkCronExpression(this.cronExpression).then(() => {
          this.$message({
            message: 'check success',
            type: 'success'
          });
        });
      },

      updateCronExpression() {
        CronTriggerAdapter.putCronExpression(this.selectedTriggerId, this.cronExpression).then(() => {
          this.$message({
            message: 'update success',
            type: 'success'
          });
          this.setCronTriggerList();
          this.cancelDialog();
        });
      },

      deleteCronTrigger(row) {
        this.$confirm(`Delete the trigger?`, 'Delete', {
          confirmButtonText: 'Yes',
          cancelButtonText: 'No',
          type: 'warning'
        }).then(() => {
          TriggerAdapter.deleteTrigger(row.id).then(() => {
            this.$message({
              message: 'delete success',
              type: 'success'
            });
            this.setCronTriggerList();
          });
        });
      },

      cancelDialog() {
        this.selectedTriggerId = {};
        this.detailDialogVisible = false;
        this.cronExpressionUpdateDialogVisible = false;
        this.cronExpression = undefined;
      },

      openCronMaker() {
        const url = 'http://www.cronmaker.com/';
        window.open(url, '_blank');
      }
    },

    created() {
      this.setCronTriggerList();
    },

    components: {
      TriggerDetail
    }
  }
</script>

<style scoped>

</style>
