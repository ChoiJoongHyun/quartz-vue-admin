<template>
  <div>
    <div class="btn_area">
      <div style="margin-right: 50px">
        <el-tag type="info">Fired Trigger List</el-tag>
      </div>
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
                   @click="setFiredTriggerList()"></el-button>
      </div>
    </div>

    <el-table size="mini" :data="firedTriggerList" style="width: 100%">

      <el-table-column prop="id.schedulerName" label="SchedulerName">
      </el-table-column>

      <el-table-column prop="id.entryId" label="EntryId">
      </el-table-column>

      <el-table-column prop="triggerName" label="TriggerName">
      </el-table-column>

      <el-table-column prop="triggerGroup" label="TriggerGroup">
      </el-table-column>

      <el-table-column prop="instanceName" label="InstanceName">
      </el-table-column>

      <el-table-column label="FiredTime" width="120">
        <template slot-scope="scope">
          {{ scope.row.firedTime | dateByLong }} <br> {{ scope.row.firedTime | timeByLong }}
        </template>
      </el-table-column>

      <el-table-column label="SchedulerTime" width="120">
        <template slot-scope="scope">
          {{ scope.row.schedulerTime | dateByLong }} <br> {{ scope.row.schedulerTime | timeByLong }}
        </template>
      </el-table-column>

      <el-table-column prop="priority" label="Priority" width="70">
      </el-table-column>

      <el-table-column prop="state" label="State">
      </el-table-column>

      <el-table-column prop="jobName" label="JobName">
      </el-table-column>

      <el-table-column prop="jobGroup" label="JobGroup">
      </el-table-column>

      <el-table-column label="NonConcurrent">
        <template slot-scope="scope">
          {{ scope.row.isNonConcurrent }}
        </template>
      </el-table-column>

      <el-table-column label="RequestsRecovery">
        <template slot-scope="scope">
          {{ scope.row.requestsRecovery }}
        </template>
      </el-table-column>

    </el-table>
  </div>
</template>

<script>
  import FiredTriggerAdapter from '../adapter/firedTriggerAdapter';

  export default {
    name: "FiredTriggerList",

    data() {
      return {
        /* firedTriggerList example data
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
        firedTriggerList: [],
        refreshDateTime: undefined,
        repeat: false,
        intervalFnc: undefined
      }
    },

    watch:{
      $route (to, from){

        /*if(from.name ==='DashboardView') {
          this.repeatOff();
        }*/
      }
    },

    methods: {

      repeatOn() {
        this.repeat = true;
        this.intervalFnc = setInterval(() => {
          this.setFiredTriggerList();
        }, 3000);
      },

      repeatOff() {
        this.repeat = false;
        clearInterval(this.intervalFnc);
      },

      setFiredTriggerList() {
        FiredTriggerAdapter.getFiredTriggerList().then((res) => {
          this.refreshDateTime = new Date();
          this.firedTriggerList = res;
        });
      },
    },

    components : {

    },

    beforeDestroy() {
      this.repeatOff()
    },

    created() {
      this.setFiredTriggerList();
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
