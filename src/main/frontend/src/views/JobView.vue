<template>

  <QuartzJobList></QuartzJobList>

</template>

<script>
  import QuartzJobList from '../components/QuartzJobList';

  export default {
    name: "JobView",

    components: {
      QuartzJobList
    }
  }
</script>

<style scoped>

  .sub-table-area {
    margin-left: 50px;
    margin-right: 50px;
  }
</style>
