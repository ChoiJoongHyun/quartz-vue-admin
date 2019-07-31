<template>
  <div>
    <el-form ref="simpleTriggerFormRules" :rules="simpleTriggerFormRules" :model="simpleTriggerForm" size="mini" label-width="140px">

      <el-form-item label="TriggerGroup" prop="triggerGroup">
        <el-input v-model="simpleTriggerForm.triggerGroup" style="width: 80%"></el-input>
        <!--<el-button type="primary" icon="el-icon-edit" circle style="margin-left: 20px"></el-button>-->
      </el-form-item>

      <el-form-item label="TriggerName" prop="triggerName">
        <el-input v-model="simpleTriggerForm.triggerName" style="width: 80%"></el-input>
      </el-form-item>

      <el-form-item label="Priority">
        <el-input-number v-model="simpleTriggerForm.priority" :min="0" :max="100"></el-input-number>
      </el-form-item>

      <el-form-item label="StartTime">
        <el-date-picker v-model="simpleTriggerForm.startTime"
                        type="datetime"
                        value-format="yyyy-MM-dd HH:mm:ss"
                        placeholder="Select date and time">
        </el-date-picker>
      </el-form-item>

      <el-form-item label="EndTime">
        <el-date-picker v-model="simpleTriggerForm.endTime"
                        type="datetime"
                        value-format="yyyy-MM-dd HH:mm:ss"
                        placeholder="Select date and time">
        </el-date-picker>
      </el-form-item>

      <el-form-item label="RepeatCount">
        <el-input-number v-model="simpleTriggerForm.repeatCount" :min="1"></el-input-number>
      </el-form-item>

      <el-form-item label="RepeatInterval">
        <el-select v-model="simpleTriggerForm.repeatIntervalType"
                   placeholder="Select" style="width: 150px">
          <el-option v-for="item in repeatIntervalSelectBox"
                     :key="item.value"
                     :label="item.label"
                     :value="item.value">
          </el-option>
        </el-select>
        <el-input-number v-model="simpleTriggerForm.repeatInterval" :min="0" style="margin-left: 20px"></el-input-number>

      </el-form-item>

      <el-form-item label="Description">
        <el-input v-model="simpleTriggerForm.description" type="textarea" style="width: 80%"></el-input>
      </el-form-item>

      <el-form-item label="JobDataMap">

        <el-row v-for="(data, index) in simpleTriggerForm.jobDataList" v-bind:key="index">
          <span>key : </span>
          <el-input v-model="data.key" style="width: 100px"></el-input>
          <span style="margin-left: 20px">value : </span>
          <el-input v-model="data.value" style="width: 180px"></el-input>
          <el-button style="margin-left: 10px;"
                     type="danger"
                     icon="el-icon-minus"
                     circle
                     size="mini"
                     @click="removeJobDataMap(index)"></el-button>
        </el-row>
        <el-button type="success"
                   size="mini"
                   icon="el-icon-plus"
                   circle
                   @click="addJobDataMap"></el-button>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="validThenOnSubmit">Create</el-button>
        <el-button @click="cancelForm">Cancel</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import SimpleTriggerAdapter from '../adapter/simpleTriggerAdapter';

  export default {
    name: "SimpleTriggerAdd",

    props: {
      jobId: {
        type: Object,
        required: true
      }
    },

    data() {
      return {
        simpleTriggerForm: {
          triggerName: undefined,
          triggerGroup: undefined,
          description: undefined,
          priority: 0,
          startTime: undefined,
          endTime: undefined,
          repeatCount: 0,
          repeatIntervalType: 'SECOND',
          repeatInterval: 0,
          jobDataList: []
        },

        simpleTriggerFormRules: {
          triggerGroup: [
            { required: true, message: 'Please input Trigger Group', trigger: 'blur' }
          ],
          triggerName: [
            { required: true, message: 'Please input Trigger Name', trigger: 'blur' }
          ]
        },

        repeatIntervalSelectBox: [{
          value: 'SECOND',
          label: 'Second'
        }, {
          value: 'MILLISECOND',
          label: 'Millisecond'
        }, {
          value: 'MINUTE',
          label: 'Minute'
        }, {
          value: 'HOUR',
          label: 'Hour'
        }]
      }
    },

    methods: {
      cancelForm() {
        Object.assign(this.$data.simpleTriggerForm, this.$options.data().simpleTriggerForm);
        this.$emit('cancel-form');
      },

      addJobDataMap() {
        this.simpleTriggerForm.jobDataList.push({});
      },

      removeJobDataMap(index) {
        this.simpleTriggerForm.jobDataList.splice(index, 1);
      },

      validThenOnSubmit() {
        this.$refs.simpleTriggerFormRules.validate((valid) => {
          if (valid) {
            this.onSubmit();
          } else {
            return false;
          }
        });
      },

      onSubmit() {
        this.$confirm(`Do you want to add it?`, 'ADD', {
          confirmButtonText: 'Yes',
          cancelButtonText: 'No',
          type: 'info'
        }).then(() => {
          SimpleTriggerAdapter.postSimpleTrigger(this.jobId, this.simpleTriggerForm).then((res) => {
            this.$message({
              message: 'add simple trigger success',
              type: 'success'
            });
            this.$emit('submit');
          });

        });
      }
    }
  }
</script>

<style scoped>

</style>
