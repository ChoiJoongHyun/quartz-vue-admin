<template>

  <div>

    <div>
      <span> {{jobId.schedulerName}} </span>
      <span> {{jobId.jobGroup}} </span>
      <span> {{jobId.jobName}} </span>
    </div>

    <div>
      <el-table
          :data="triggerList"
          style="width: 100%">
        <el-table-column
            prop="date"
            label="Date"
            width="180">
        </el-table-column>
        <el-table-column
            prop="name"
            label="Name"
            width="180">
        </el-table-column>
        <el-table-column
            prop="address"
            label="Address">
        </el-table-column>
      </el-table>
    </div>


  </div>

</template>

<script>
  export default {
    name: "TriggerList",

    props: {
      jobId: {
        type: Object
      }
    },

    data() {
      return {
        triggerList: [
          {
            date: '2016-05-03',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }, {
            date: '2016-05-02',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }, {
            date: '2016-05-04',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }, {
            date: '2016-05-01',
            name: 'Tom',
            address: 'No. 189, Grove St, Los Angeles'
          }
        ]
      }
    },

    methods: {

      setTriggerList() {
        if(this.jobId) {
          console.log(this.jobId.schedulerName);
        } else {
          console.log("no job id");
        }
      }

    },

    created() {
      this.setTriggerList();
    }

  }
</script>

<style scoped>

</style>
