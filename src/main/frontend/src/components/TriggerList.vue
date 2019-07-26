<template>

  <div>
    <div>
      <!--TODO refresh btn-->
    </div>

    <div>
      <el-table :data="triggerList" style="width: 100%" size="mini">

        <el-table-column prop="id.triggerGroup" label="TriggerGroup" sortable>
        </el-table-column>

        <el-table-column prop="id.triggerName" label="TriggerName" sortable>
        </el-table-column>

        <el-table-column prop="priority" label="Priority" sortable width="90">
        </el-table-column>

        <el-table-column label="PrevFireTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.prevFireTime | dateformatByLong }}
          </template>
        </el-table-column>

        <el-table-column label="NextFireTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.nextFireTime | dateformatByLong }}
          </template>
        </el-table-column>

        <el-table-column label="StartTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.startTime | dateformatByLong }}
          </template>
        </el-table-column>

        <el-table-column label="EndTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.endTime | dateformatByLong }}
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

      </el-table>
    </div>

    <template>
      <el-dialog title="Detail"
                 width="35%"
                 align="left"
                 :visible.sync="detailDialogVisible"
                 :before-close="handleClose">

        <TriggerDetail v-if="detailDialogVisible"
                       :trigger-id="selectedTriggerId"
                       @submit="submitDetailForm"
                       @cancel-form="cancelDialog">
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
              "isDurable": true,
              "isNonConcurrent": true,
              "isUpdateData": true,
              "requestsRecovery": false,
              "jobData": "job_data_1"
            }
          }]
        * */
        triggerList: [],
        selectedTriggerId: {},
        detailDialogVisible: false
      }
    },

    methods: {

      setTriggerList() {
        TriggerAdapter.getTriggerListByJobId(this.jobId)
          .then((res) => {
            this.triggerList = res;
        });
      },

      showDetailTrigger(row) {
        this.detailDialogVisible = true;
        this.selectedTriggerId = row.id;
      },

      submitDetailForm() {
        alert('submitDetailForm');
      },

      cancelDialog() {
        this.selectedJobId = {};
        this.detailDialogVisible = false;
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

</style>
