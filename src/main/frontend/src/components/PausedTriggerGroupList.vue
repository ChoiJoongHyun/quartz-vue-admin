<template>
  <div>
    <div class="btn_area">
      <el-tag type="info">Paused Trigger Group List</el-tag>

      <el-button style="margin-left: 20px" type="primary"
                 title="refresh"
                 plain
                 icon="el-icon-refresh"
                 size="mini"
                 @click="setPausedTriggerGroupList()"></el-button>
    </div>

    <el-table style="width: 100%"
              :data="pausedTriggerGroupList"
              v-loading="loading"
              size="mini">
      <el-table-column prop="schedulerName"
                       label="SchedulerName">
      </el-table-column>
      <el-table-column prop="triggerGroup"
                       label="TriggerGroup">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import PausedTriggerGroupAdapter from '../adapter/pausedTriggerGroupAdapter';

  export default {
    name: "PausedTriggerGroupList",

    data() {
      return {
        /*
        * [{
            "schedulerName": "scheduler-name-01",
            "triggerGroup": "trigger-group-01"
          }]
        * */
        pausedTriggerGroupList: [],
        loading: false
      }
    },

    methods: {
      setPausedTriggerGroupList() {
        this.loading = true;
        PausedTriggerGroupAdapter.getPausedTriggerGroupList().then((res) => {
          this.pausedTriggerGroupList = res;
          this.loading = false;
        }).catch(reason => {
          this.loading = false;
        });
      }
    },

    created() {
      this.setPausedTriggerGroupList();
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
