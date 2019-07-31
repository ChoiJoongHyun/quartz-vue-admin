<template>
  <div>
    <div class="btn_area">
      <el-tag  type="info">Trigger List</el-tag>

      <el-button style="margin-left: 20px" type="primary"
                 title="refresh"
                 plain
                 icon="el-icon-refresh"
                 size="mini"
                 @click="setTriggerList()"></el-button>
    </div>

    <div>
      <el-table style="width: 100%"
                :data="triggerList"
                v-loading="loading"
                size="mini">

        <el-table-column prop="id.triggerGroup" label="TriggerGroup" sortable>
        </el-table-column>

        <el-table-column prop="id.triggerName" label="TriggerName" sortable>
        </el-table-column>

        <el-table-column prop="priority" label="Priority" sortable width="90">
        </el-table-column>

        <el-table-column label="PrevFireTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.prevFireTime | dateByLong }} <br> {{ scope.row.prevFireTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column label="NextFireTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.nextFireTime | dateByLong }} <br> {{ scope.row.nextFireTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column label="StartTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.startTime | dateByLong }} <br> {{ scope.row.startTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column label="EndTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.endTime | dateByLong }} <br> {{ scope.row.endTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column prop="calendarName" label="CalendarName" sortable>
        </el-table-column>

        <el-table-column prop="triggerType" label="TriggerType" sortable>
        </el-table-column>

        <el-table-column prop="triggerState" label="TriggerState" sortable>
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
                       @click="deleteTrigger(scope.row)"
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
  import TriggerDetail from './TriggerDetail';

  export default {
    name: "TriggerList",

    props: {
      jobId: {
        type: Object
      }
    },

    data() {
      return {
        /*
        * [{
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
          }]
        * */
        triggerList: [],
        selectedTriggerId: {},
        detailDialogVisible: false,
        loading: false
      }
    },

    methods: {

      setTriggerList() {
        this.loading = true;
        TriggerAdapter.getTriggerListByJobId(this.jobId).then((res) => {
          this.triggerList = res;
          this.loading = false;
        }).catch(reason => {
          this.loading = false;
        });
      },

      showDetailTrigger(row) {
        this.detailDialogVisible = true;
        this.selectedTriggerId = row.id;
      },

      deleteTrigger(row) {
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
            this.setTriggerList();
          });
        });
      },

      handleClose(done) {
        done();
      }
    },

    created() {
      this.setTriggerList();
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
