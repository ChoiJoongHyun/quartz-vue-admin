<template>
  <div class="info">
    <div>
      <h2 class="title"> Quartz Scheduler Monitoring </h2>
      <div class="content">
        <h3> What is the Quartz Scheduler Monitoring ? </h3>
        <h5>
          It is an application that monitors the scheduler developed by <el-button type="text" @click="openQuartzScheduler">Quartz Scheduler Library</el-button>.
        </h5>
        <h5>
          It is available by registering SimpleTrigger to QuartzJob.
        </h5>
      </div>
    </div>

    <el-divider></el-divider>

    <div>
      <el-button type="text" @click="openGitHub">GitHub</el-button>
      <el-button type="text" @click="openQuartzScheduler">Quartz Scheduler</el-button>
    </div>
  </div>
</template>

<script>
  export default {
    name: "ProjectInfo",

    methods: {

      openQuartzScheduler() {
        const quartzSchedulerHomePage = "http://www.quartz-scheduler.org/";
        window.open(quartzSchedulerHomePage, '_blank');
      },

      openGitHub() {
        const gitHubUrl = "https://github.com/ChoiJoongHyun/quartz-vue-admin";
        window.open(gitHubUrl, '_blank');
      }
    }
  }
</script>

<style scoped>

  .info {
    text-align: left;
  }

  .title {
    font-size: 45px;
  }

  .content {
    margin-left: 30px;
  }

</style>
