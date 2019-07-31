import ErrorHandler from './errorHandler';

const PATH = '/api/simple/triggers';

export default {

  getSimpleTriggerList() {
    return new Promise(function (resolve, reject) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  },

  /**
   * @param jobId {object}
   * @param form {object}
   * */
  postSimpleTrigger(jobId, form) {
    return new Promise(function (resolve, reject) {
      Axios.post(PATH + '/scheduler-names/' + jobId.schedulerName + '/job-groups/' + jobId.jobGroup + '/job-names/' + jobId.jobName, form)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  }

}

