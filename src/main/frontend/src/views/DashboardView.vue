<template>
  <div>
    <div style="margin-bottom: 35px">
      <FiredTriggerList ref="firedTriggerList"></FiredTriggerList>
    </div>

    <el-row type="flex" class="row-bg" justify="space-between">
      <el-col :span="9">
        <SchedulerStateList></SchedulerStateList>
      </el-col>
      <el-col :span="7">
        <LockList></LockList>
      </el-col>
      <el-col :span="7">
        <PausedTriggerGroupList></PausedTriggerGroupList>
      </el-col>
    </el-row>
  </div>

</template>

<script>

  import FiredTriggerList from '../components/FiredTriggerList';
  import SchedulerStateList from '../components/SchedulerStateList';
  import LockList from '../components/LockList';
  import PausedTriggerGroupList from '../components/PausedTriggerGroupList';

  export default {
    name: "DashboardView",

    data() {
      return {

      }
    },

    watch:{
      $route (to, from){
        if(from.name ==='DashboardView') {
          this.$refs.firedTriggerList.repeatOff();
        }
      }
    },

    components : {
      FiredTriggerList, SchedulerStateList, LockList, PausedTriggerGroupList
    }
  }
</script>

<style scoped>
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
