<template>

  <div>

    <div>

    </div>

    <div>

      <el-table :data="simpleTriggerList" style="width: 100%" size="mini">

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


        <el-table-column prop="repeatCount" label="RepeatCount">
        </el-table-column>

        <el-table-column prop="repeatInterval" label="RepeatInterval (ms)">
        </el-table-column>

        <el-table-column prop="timesTriggered" label="TimesTriggered">
        </el-table-column>


        <el-table-column prop="trigger.triggerState" label="TriggerState" sortable>
        </el-table-column>

      </el-table>
    </div>

    </div>

  </div>

</template>

<script>
  import SimpleTriggerAdapter from '../adapter/simpleTriggerAdapter';

  export default {
    name: "SimpleTriggerList",

    data() {
      return {

        simpleTriggerList: []

      }
    },
    methods: {

      setSimpleTriggerList() {
        SimpleTriggerAdapter.getSimpleTriggerList().then((res) => {
          this.simpleTriggerList = res;
        });
      }
    },

    created() {
      this.setSimpleTriggerList();
    },

    components: {

    }
  }
</script>

<style scoped>

</style>
