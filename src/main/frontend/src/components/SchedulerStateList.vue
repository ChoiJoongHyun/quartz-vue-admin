<template>

  <div>
    <el-tag style="display: flex" type="info">Scheduler State List</el-tag>

    <el-table :data="schedulerStateList"
              size="mini"
              style="width: 100%">
      <el-table-column prop="id.schedulerName"
                       label="SchedulerName">
      </el-table-column>
      <el-table-column prop="id.instanceName"
                       label="InstanceName">
      </el-table-column>
      <el-table-column label="LastCheckinTime">
        <template slot-scope="scope">
          {{ scope.row.lastCheckinTime | dateformatByLong }}
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

</style>
