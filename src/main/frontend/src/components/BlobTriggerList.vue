<template>

  <div>
    <div>
      <el-table style="width: 100%"
                :data="blobTriggerList"
                v-loading="loading"
                size="mini">

        <el-table-column prop="id.schedulerName" label="SchedulerName" sortable>
        </el-table-column>

        <el-table-column prop="id.triggerGroup" label="TriggerGroup" sortable>
        </el-table-column>

        <el-table-column prop="id.triggerName" label="TriggerName" sortable>
        </el-table-column>

        <el-table-column prop="trigger.jobGroup" label="JobGroup" sortable>
        </el-table-column>

        <el-table-column prop="trigger.jobName" label="JobName" sortable>
        </el-table-column>

        <el-table-column label="PrevFireTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.trigger.prevFireTime | dateByLong }} <br> {{ scope.row.trigger.prevFireTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column label="NextFireTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.trigger.nextFireTime | dateByLong }} <br> {{ scope.row.trigger.nextFireTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column label="StartTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.trigger.startTime | dateByLong }} <br> {{ scope.row.trigger.startTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column label="EndTime" sortable width="120">
          <template slot-scope="scope">
            {{ scope.row.trigger.endTime | dateByLong }} <br> {{ scope.row.trigger.endTime | timeByLong }}
          </template>
        </el-table-column>

        <el-table-column prop="trigger.triggerState" label="TriggerState" sortable>
        </el-table-column>

        <el-table-column label="BlobData">

        </el-table-column>

      </el-table>
    </div>

  </div>

</template>

<script>
  import BlobTriggerAdapter from '../adapter/blobTriggerAdapter';

  export default {
    name: "BlobTriggerList",

    data() {
      return {
        blobTriggerList: [],
        loading : false
      }
    },

    methods: {

      setBlobTriggerList() {
        this.loading = true;
        BlobTriggerAdapter.getBlobTriggerList().then((res) => {
          this.blobTriggerList = res;
          this.loading = false;
        }).catch(reason => {
          this.loading = false;
        });
      }
    },

    created() {
      this.setBlobTriggerList();
    }
  }
</script>

<style scoped>

</style>
