import ErrorHandler from './errorHandler';

const PATH = '/api/triggers';

export default {

  /**
   * @param triggerId {object}
   * */
  getTrigger(triggerId) {
    return new Promise(function (resolve, reject) {
      Axios.get(PATH + '/scheduler-names/' + triggerId.schedulerName + '/trigger-groups/' + triggerId.triggerGroup + '/trigger-names/' + triggerId.triggerName)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  },

  /**
   * @param triggerId {object}
   * */
  getTriggerListByJobId(jobId) {
    return new Promise(function (resolve, reject) {
      Axios.get(PATH + '/scheduler-names/' + jobId.schedulerName + '/job-groups/' + jobId.jobGroup + '/job-names/' + jobId.jobName)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  },

  /**
   * @param triggerId {object}
   * */
  deleteTrigger(triggerId) {
    return new Promise(function (resolve, reject) {
      Axios.delete(PATH + '/scheduler-names/' + triggerId.schedulerName + '/trigger-groups/' + triggerId.triggerGroup + '/trigger-names/' + triggerId.triggerName)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  }
}
