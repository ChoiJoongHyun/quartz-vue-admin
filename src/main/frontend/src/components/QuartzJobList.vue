<template>
  <div>
    <el-table :data="jobList"
              stripe
              size="mini"
              style="width: 100%">

      <el-table-column type="expand">
        <template slot-scope="props">
          <div class="sub-table-area">
            <p>Description : {{ props.row.description }}</p>
            <p style="margin-bottom: 20px">JobClassName : {{ props.row.jobClassName }}</p>

            <el-tag type="info">Trigger List</el-tag>

            <TriggerList :jobId="props.row.id">
            </TriggerList>
          </div>
        </template>
      </el-table-column>

      <el-table-column prop="id.schedulerName" label="SchedulerName" sortable>
      </el-table-column>

      <el-table-column prop="id.jobName" label="JobName" sortable>
      </el-table-column>

      <el-table-column prop="id.jobGroup" label="JobGroup" sortable>
      </el-table-column>

      <el-table-column label="Durable" width="80">
        <template slot-scope="scope">
          {{ scope.row.isDurable }}
        </template>
      </el-table-column>

      <el-table-column label="NonConcurrent" width="130">
        <template slot-scope="scope">
          {{ scope.row.isNonConcurrent }}
        </template>
      </el-table-column>

      <el-table-column label="UpdateData" width="100">
        <template slot-scope="scope">
          {{ scope.row.isUpdateData }}
        </template>
      </el-table-column>

      <el-table-column label="RequestsRecovery" width="150">
        <template slot-scope="scope">
          {{ scope.row.requestsRecovery }}
        </template>
      </el-table-column>

      <el-table-column label="Add SimpleTrigger" width="150">
        <template slot-scope="scope">
          <el-button type="primary"
                     icon="el-icon-plus"
                     size="mini"
                     @click="addSimpleTrigger(scope.row)">ADD
          </el-button>
        </template>
      </el-table-column>

      <el-table-column label="Detail" width="70">
        <template slot-scope="scope">
          <el-button type="primary"
                     icon="el-icon-edit"
                     size="mini"
                     circle
                     @click="detailJob(scope.row)"
          ></el-button>
        </template>
      </el-table-column>

      <el-table-column label="Delete" width="70">
        <template slot-scope="scope">
          <el-button type="danger"
                     icon="el-icon-delete"
                     size="mini"
                     @click="deleteJob(scope.row)"
                     circle></el-button>
        </template>
      </el-table-column>

    </el-table>

    <template>
      <el-dialog title="Detail" :visible.sync="detailDialogVisible"
                 width="35%"
                 align="left"
                 :before-close="handleClose">

        <QuartzJobDetail v-if="detailDialogVisible"
                         :job-id="selectedJobId"
                         @submit="submitDetailForm"
                         @cancel-form="cancelDetailForm"></QuartzJobDetail>

      </el-dialog>
    </template>
  </div>


</template>

<script>
  import TriggerList from '../components/TriggerList';
  import QuartzJobDetail from '../components/QuartzJobDetail';

  import JobAdapter from '../adapter/jobAdapter';

  export default {
    name: "QuartzJobList",

    data() {
      return {
        /* jobList example data
        * [{
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
            "jobData": null
          }]
        * */
        jobList: [],
        selectedJobId: {},
        detailDialogVisible: false
      }
    },

    methods: {
      setJobList() {
        JobAdapter.getJobList().then((res) => {
          this.jobList = res;
        });
      },

      deleteJob(row) {
        JobAdapter.deleteJob(row.id.schedulerName, row.id.jobGroup, row.id.jobName).then((res) => {
          this.jobList = res;
        });
      },

      addSimpleTrigger(row) {
        alert("add");
      },

      detailJob(row) {
        this.selectedJobId = row.id;
        this.detailDialogVisible = true;
      },

      cancelDetailForm() {
        this.selectedJobId = {};
        this.detailDialogVisible = false;
      },

      submitDetailForm() {
        this.selectedJobId = {};
        this.detailDialogVisible = false;
        this.setJobList();
      },

      handleClose(done) {
        done();
      }
    },

    created() {
      this.setJobList();
    },

    components: {
      TriggerList, QuartzJobDetail
    }
  }
</script>

<style scoped>
  .sub-table-area {
    margin-left: 50px;
    margin-right: 50px;
    margin-bottom: 30px;
  }
</style>
