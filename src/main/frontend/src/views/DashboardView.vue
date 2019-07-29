<template>
  <div>
    <div>
      <FiredTriggerList ref="firedTriggerList"></FiredTriggerList>
    </div>

    <div>
      <SchedulerStateList></SchedulerStateList>
    </div>

    <div>
      <LockList></LockList>
    </div>
  </div>

</template>

<script>

  import FiredTriggerList from '../components/FiredTriggerList';
  import SchedulerStateList from '../components/SchedulerStateList';
  import LockList from '../components/LockList';

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

    methods: {

    },

    components : {
      FiredTriggerList, SchedulerStateList, LockList
    },

    beforeDestroy() {

    },

    created() {

    }
  }
</script>

<style scoped>

</style>
