<template>
  <div>
    <div class="btn_area">
      <el-tag type="info">Lock List</el-tag>

      <el-button style="margin-left: 20px" type="primary"
                 title="refresh"
                 plain
                 icon="el-icon-refresh"
                 size="mini"
                 @click="setLockList()"></el-button>
    </div>

    <el-table style="width: 100%"
              :data="lockList"
              v-loading="loading"
              size="mini">
      <el-table-column prop="schedulerName"
                       label="SchedulerName">
      </el-table-column>
      <el-table-column prop="lockName"
                       label="LockName">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import LockAdapter from '../adapter/lockAdapter';

  export default {
    name: "LockList",

    data() {
      return {
        /*
        * [{
            "schedulerName": "scheduler-name-01",
            "lockName": "STATE_ACCESS"
          }]
        * */
        lockList: [],
        loading: false
      }
    },

    methods: {
      setLockList() {
        this.loading = true;
        LockAdapter.getLockList().then((res) => {
          this.lockList = res;
          this.loading = false;
        }).catch(reason => {
          this.loading = false;
        });
      }
    },

    created() {
      this.setLockList();
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
