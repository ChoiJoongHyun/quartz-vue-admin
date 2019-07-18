<template>
  <div>
    <div class="btn_area">
      <div style="margin-top: 2px">
        <el-button v-if="repeat"
                   title="auto refresh stop"
                   type="primary"
                   icon="el-icon-minus"
                   size="mini"
                   @click="repeatOff"></el-button>
        <el-button v-else
                   title="auto refresh start"
                   type="primary"
                   icon="el-icon-caret-right"
                   size="mini"
                   @click="repeatOn"></el-button>
      </div>
      <div style="margin-left: 10px">
        <el-tag type="info">refresh date time : {{refreshDateTime | dateformatByDate}}</el-tag>
      </div>
      <div style="margin-left: 20px; margin-top: 2px">
        <el-button type="primary"
                   title="refresh"
                   icon="el-icon-refresh"
                   circle
                   size="mini"
                   @click="generateData()"></el-button>
      </div>
    </div>

    <el-table size="mini" :data="tableData" style="width: 100%">

      <el-table-column prop="id.schedulerName" label="schedulerName">
      </el-table-column>

      <el-table-column prop="id.entryId" label="entryId">
      </el-table-column>

      <el-table-column prop="triggerName" label="triggerName">
      </el-table-column>

      <el-table-column prop="triggerGroup" label="triggerGroup">
      </el-table-column>

      <el-table-column prop="instanceName" label="instanceName">
      </el-table-column>

      <el-table-column label="firedTime">
        <template slot-scope="scope">
          {{ scope.row.firedTime | dateformatByLong }}
        </template>
      </el-table-column>

      <el-table-column label="schedulerTime">
        <template slot-scope="scope">
          {{ scope.row.schedulerTime | dateformatByLong }}
        </template>
      </el-table-column>

      <el-table-column prop="priority" label="priority">
      </el-table-column>

      <el-table-column prop="state" label="state">
      </el-table-column>

      <el-table-column prop="jobName" label="jobName">
      </el-table-column>

      <el-table-column prop="jobGroup" label="jobGroup">
      </el-table-column>

      <el-table-column prop="isNonConcurrent" label="isNonConcurrent">
      </el-table-column>

      <el-table-column prop="requestsRecovery" label="requestsRecovery">
      </el-table-column>

    </el-table>
  </div>
</template>

<script>
  import FiredTriggerAdapter from '../adapter/firedTriggerAdapter';

  export default {
    name: "DashboardView",

    data() {
      return {
        /* tableData example data
        [{
          "id": {
            "schedulerName": "scheduler-name-01",
            "entryId": "DESKTOP-0QF2KQT1"
          },
          "triggerName": "trigger-name-01",
          "triggerGroup": "trigger-group-01",
          "instanceName": "DESKTOP",
          "firedTime": 1547016750249,
          "schedulerTime": 1547016780000,
          "priority": 0,
          "state": "EXECUTING",
          "jobName": "job-name-01",
          "jobGroup": "job-group-01",
          "isNonConcurrent": true,
          "requestsRecovery": false
        }]
        */
        tableData: [],
        refreshDateTime: null,
        repeat: false,
        intervalFnc: null
      }
    },

    methods: {

      repeatOn() {
        this.repeat = true;
        this.intervalFnc = setInterval(() => {
          this.generateData();
        }, 3000);
      },

      repeatOff() {
        this.repeat = false;
        clearInterval(this.intervalFnc);
      },

      setTableData() {
        FiredTriggerAdapter.getFiredTriggerList().then((res) => {
          this.tableData = res;
        });
      },

      generateData() {
        this.refreshDateTime = new Date();
        this.setTableData();
      }

    },

    components : {

    },

    beforeDestroy() {
      this.repeatOff()
    },

    created() {
      this.generateData();
    }
  }
</script>

<style scoped>
  .btn_area{
    margin-left: 10px;
    margin-bottom: 10px;
    display: flex;
  }
  .el-row {
    margin-bottom: 20px;

  }

</style>
