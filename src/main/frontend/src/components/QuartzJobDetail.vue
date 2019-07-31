<template>
  <div>
    <el-form ref="form" :model="job" size="mini" label-width="140px">
      <el-form-item label="SchedulerName">
        <el-input v-model="job.id.schedulerName" disabled></el-input>
      </el-form-item>

      <el-form-item label="JobGroup">
        <el-input v-model="job.id.jobGroup" disabled></el-input>
      </el-form-item>

      <el-form-item label="JobName">
        <el-input v-model="job.id.jobName" disabled></el-input>
      </el-form-item>

      <el-form-item label="Durable">
        <el-checkbox v-model="job.durable" disabled></el-checkbox>
      </el-form-item>

      <el-form-item label="NonConcurrent">
        <el-checkbox v-model="job.nonConcurrent" disabled></el-checkbox>
      </el-form-item>

      <el-form-item label="UpdateData">
        <el-checkbox v-model="job.updateData" disabled></el-checkbox>
      </el-form-item>

      <el-form-item label="RequestsRecovery">
        <el-checkbox v-model="job.requestsRecovery" disabled></el-checkbox>
      </el-form-item>

      <el-form-item label="JobClassName">
        <el-input v-model="job.jobClassName" disabled></el-input>
      </el-form-item>

      <el-form-item label="Description">
        <el-input type="textarea" v-model="job.description" disabled></el-input>
      </el-form-item>

      <el-form-item label="JobData">
        <pre>{{job.jobData}}</pre>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import JobAdapter from '../adapter/jobAdapter';

  export default {
    name: "QuartzJobDetail",

    props: {
      jobId: {
        type: Object,
        required: true
      }
    },

    data() {
      return {
        job: {
          id: {}
        }
      }
    },

    methods: {

      setJob() {
        JobAdapter.getJob(this.jobId)
          .then((res) => {
            this.job = res;
        });
      }
    },

    created() {
      this.setJob();
    }
  }
</script>

<style scoped>

</style>
