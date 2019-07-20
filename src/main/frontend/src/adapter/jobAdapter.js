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

  deleteJob(schedulerName, jobGroup, jobName) {
    return new Promise(function (resolve) {
      Axios.delete(PATH + '/scheduler-names/' + schedulerName + '/job-groups/' + jobGroup + '/job-names/' + jobName)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }
}
