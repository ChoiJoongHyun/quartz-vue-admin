<template>
  <div>
    <FiredTriggerList ref="firedTriggerList"></FiredTriggerList>
  </div>
</template>

<script>

  import FiredTriggerList from '../components/FiredTriggerList';

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
      FiredTriggerList
    },

    beforeDestroy() {

    },

    created() {

    }
  }
</script>

<style scoped>

</style>
