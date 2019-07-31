<template>
  <div>
    <div class="btn_area">
      <el-tag  type="info">Simple Trigger List</el-tag>

      <el-button style="margin-left: 20px" type="primary"
                 title="refresh"
                 plain
                 icon="el-icon-refresh"
                 size="mini"
                 @click="setSimpleTriggerList()"></el-button>
    </div>

    <el-table style="width: 100%"
              :data="simpleTriggerList"
              v-loading="loading"
              size="mini">
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


      <el-table-column prop="repeatCount" label="RepeatCount">
      </el-table-column>

      <el-table-column prop="repeatInterval" label="RepeatInterval (ms)">
      </el-table-column>

      <el-table-column prop="timesTriggered" label="TimesTriggered">
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
                     @click="deleteSimpleTrigger(scope.row)"
                     circle></el-button>
        </template>
      </el-table-column>
    </el-table>

    <template>
      <el-dialog title="Trigger Detail"
                 width="35%"
                 align="left"
                 :visible.sync="detailDialogVisible"
                 :before-close="handleClose">

        <TriggerDetail v-if="detailDialogVisible"
                       :trigger-id="selectedTriggerId">
        </TriggerDetail>

      </el-dialog>
    </template>
  </div>
</template>

<script>

  import TriggerAdapter from '../adapter/triggerAdapter';
  import SimpleTriggerAdapter from '../adapter/simpleTriggerAdapter';
  import TriggerDetail from './TriggerDetail';

  export default {
    name: "SimpleTriggerList",

    data() {
      return {
        /*
        * [{
            "id": {
              "schedulerName": "scheduler-name-02",
              "triggerGroup": "trigger-group-02",
              "triggerName": "trigger-name-02"
            },
            "repeatCount": 0,
            "repeatInterval": 0,
            "timesTriggered": 1,
            "trigger": {
              "id": {
                "schedulerName": "scheduler-name-02",
                "triggerGroup": "trigger-group-02",
                "triggerName": "trigger-name-02"
              },
              "jobName": "job-name-02",
              "jobGroup": "job-group-02",
              "description": "description",
              "nextFireTime": 1530543600000,
              "prevFireTime": -1,
              "priority": 0,
              "triggerState": "WAITING",
              "triggerType": "SIMPLE",
              "startTime": 1530543600000,
              "endTime": 0,
              "calendarName": null,
              "misfireInstr": 0,
              "jobData": null,
              "jobDetail": {
                "id": {
                  "schedulerName": "scheduler-name-02",
                  "jobName": "job-name-02",
                  "jobGroup": "job-group-02"
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
          }]
        * */
        simpleTriggerList: [],
        selectedTriggerId: {},
        detailDialogVisible: false,
        loading: false
      }
    },
    methods: {

      setSimpleTriggerList() {
        this.loading = true;
        SimpleTriggerAdapter.getSimpleTriggerList().then((res) => {
          this.simpleTriggerList = res;
          this.loading = false;
        }).catch(reason => {
          this.loading = false;
        });
      },

      showDetailTrigger(row) {
        this.detailDialogVisible = true;
        this.selectedTriggerId = row.id;
      },

      deleteSimpleTrigger(row) {
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
            this.setSimpleTriggerList();
          });
        });
      },

      handleClose(done) {
        done();
      }
    },

    created() {
      this.setSimpleTriggerList();
    },

    components: {
      TriggerDetail
    }
  }
</script>

<style scoped>
  .btn_area{
    margin-left: 10px;
    margin-bottom: 10px;
    display: flex;
  }
</style>
