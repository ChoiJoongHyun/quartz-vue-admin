import ErrorHandler from './errorHandler';

const PATH = '/api/simple/triggers';

export default {

  getSimpleTriggerList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  },

  postSimpleTrigger(jobId, form) {
    return new Promise(function (resolve) {
      Axios.post(PATH + '/scheduler-names/' + jobId.schedulerName + '/job-groups/' + jobId.jobGroup + '/job-names/' + jobId.jobName, form)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }

}

