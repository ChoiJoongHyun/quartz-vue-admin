<template>
  <div>
    <div class="btn_area">
      <el-tag type="info">Scheduler State List</el-tag>

      <el-button style="margin-left: 20px" type="primary"
                 title="refresh"
                 plain
                 icon="el-icon-refresh"
                 size="mini"
                 @click="setSchedulerStateList()"></el-button>
    </div>

    <el-table :data="schedulerStateList"
              size="mini"
              style="width: 100%">
      <el-table-column prop="id.schedulerName"
                       label="SchedulerName">
      </el-table-column>
      <el-table-column prop="id.instanceName"
                       label="InstanceName">
      </el-table-column>
      <el-table-column label="LastCheckinTime" width="120">
        <template slot-scope="scope">
          {{ scope.row.lastCheckinTime | dateByLong }} <br> {{ scope.row.lastCheckinTime | timeByLong }}
        </template>
      </el-table-column>
      <el-table-column prop="checkinInterval"
                       label="CheckinInterval">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import SchedulerStateAdapter from '../adapter/schedulerStateAdapter';

  export default {

    name: "SchedulerStateList",

    data() {
      return {
        /*
        * [{
            "id": {
              "schedulerName": "scheduler-name-01",
              "instanceName": "DESKTOP"
            },
            "lastCheckinTime": 1558926852046,
            "checkinInterval": 20000
          }]
        * */
        schedulerStateList: []
      }
    },

    methods: {
      setSchedulerStateList() {
        SchedulerStateAdapter.getSchedulerStateList()
          .then((res) => this.schedulerStateList = res);
      }
    },

    created() {
      this.setSchedulerStateList();
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
