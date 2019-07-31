import ErrorHandler from './errorHandler';

const PATH = '/api/jobs';

export default {

  getJobList() {
    return new Promise(function (resolve, reject) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  },

  /**
   * @param jobId {object}
   * */
  getJob(jobId) {
    return new Promise(function (resolve, reject) {
      Axios.get(PATH + '/scheduler-names/' + jobId.schedulerName + '/job-groups/' + jobId.jobGroup + '/job-names/' + jobId.jobName)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  },

  /**
   * @param jobId {object}
   * */
  deleteJob(jobId) {
    return new Promise(function (resolve, reject) {
      Axios.delete(PATH + '/scheduler-names/' + jobId.schedulerName + '/job-groups/' + jobId.jobGroup + '/job-names/' + jobId.jobName)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  }
}
