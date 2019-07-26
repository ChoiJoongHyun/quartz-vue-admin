import ErrorHandler from './errorHandler';

const PATH = '/api/triggers';

export default {

  getTriggerList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  },

  getTrigger(triggerId) {
    return new Promise(function (resolve) {
      Axios.get(PATH + '/scheduler-names/' + triggerId.schedulerName + '/trigger-groups/' + triggerId.triggerGroup + '/trigger-names/' + triggerId.triggerName)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  },

  getTriggerListByJobId(jobId) {
    return new Promise(function (resolve) {
      Axios.get(PATH + '/scheduler-names/' + jobId.schedulerName + '/job-groups/' + jobId.jobGroup + '/job-names/' + jobId.jobName)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  },

  deleteTrigger(triggerId) {
    return new Promise(function (resolve) {
      Axios.delete(PATH + '/scheduler-names/' + triggerId.schedulerName + '/trigger-groups/' + triggerId.triggerGroup + '/trigger-names/' + triggerId.triggerName)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }

}
