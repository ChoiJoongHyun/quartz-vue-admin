<template>

  <div>
    <div>
      <!--TODO refresh btn-->
    </div>

    <div>
      <el-table :data="blobTriggerList" style="width: 100%" size="mini">

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

        <!--<el-table-column prop="cronExpression" label="CronExpression">
        </el-table-column>

        <el-table-column prop="timeZoneId" label="TimeZoneId">
        </el-table-column>-->







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
        blobTriggerList: []
      }
    },

    methods: {

      setBlobTriggerList() {
        BlobTriggerAdapter.getBlobTriggerList().then((res) => {
          this.blobTriggerList = res;
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
