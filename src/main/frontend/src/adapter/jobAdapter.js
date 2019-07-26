import ErrorHandler from './errorHandler';

const PATH = '/api/jobs';

export default {

  getJobList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  },

  getJob(jobId) {
    return new Promise(function (resolve) {
      Axios.get(PATH + '/scheduler-names/' + jobId.schedulerName + '/job-groups/' + jobId.jobGroup + '/job-names/' + jobId.jobName)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  },

  putJob(jobId, form) {
    return new Promise(function (resolve) {
      Axios.put(PATH + '/scheduler-names/' + jobId.schedulerName + '/job-groups/' + jobId.jobGroup + '/job-names/' + jobId.jobName, form)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  },

  deleteJob(jobId) {
    return new Promise(function (resolve) {
      Axios.delete(PATH + '/scheduler-names/' + jobId.schedulerName + '/job-groups/' + jobId.jobGroup + '/job-names/' + jobId.jobName)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }
}
