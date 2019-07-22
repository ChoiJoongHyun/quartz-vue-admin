<template>

  <div>
    <div>
      <!--TODO refresh btn-->
    </div>

    <div>
      <el-table :data="simpropTriggerList" style="width: 100%" size="mini">

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


        <el-table-column prop="strProp1" label="StrProp1">
        </el-table-column>
        <el-table-column prop="strProp2" label="StrProp2">
        </el-table-column>
        <el-table-column prop="strProp3" label="StrProp3">
        </el-table-column>
        <el-table-column prop="intProp1" label="IntProp1">
        </el-table-column>
        <el-table-column prop="intProp2" label="IntProp1">
        </el-table-column>
        <el-table-column prop="longProp1" label="LongProp1">
        </el-table-column>
        <el-table-column prop="longProp1" label="LongProp2">
        </el-table-column>
        <el-table-column prop="decProp1" label="DecProp1">
        </el-table-column>
        <el-table-column prop="decProp2" label="DecProp2">
        </el-table-column>
        <el-table-column prop="boolProp1" label="BoolProp1">
        </el-table-column>
        <el-table-column prop="boolProp2" label="BoolProp2">
        </el-table-column>


        <el-table-column label="PrevFireTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.trigger.prevFireTime | dateformatByLong }}
          </template>
        </el-table-column>

        <el-table-column label="NextFireTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.trigger.nextFireTime | dateformatByLong }}
          </template>
        </el-table-column>

        <el-table-column label="StartTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.trigger.startTime | dateformatByLong }}
          </template>
        </el-table-column>

        <el-table-column label="EndTime" sortable>
          <template slot-scope="scope">
            {{ scope.row.trigger.endTime | dateformatByLong }}
          </template>
        </el-table-column>

        <el-table-column prop="trigger.triggerState" label="TriggerState" sortable>
        </el-table-column>

      </el-table>
    </div>

  </div>

</template>

<script>
  import SimpropTriggerAdapter from '../adapter/simpropTriggerAdapter';

  export default {
    name: "SimpropTriggerList",

    data() {
      return {
        simpropTriggerList: []
      }
    },

    methods: {

      setSimpropTriggerList() {
        SimpropTriggerAdapter.getSimpropTriggerList().then((res) => {
          this.simpropTriggerList = res;
        });
      }
    },

    created() {
      this.setSimpropTriggerList();
    }
  }
</script>

<style scoped>

</style>
