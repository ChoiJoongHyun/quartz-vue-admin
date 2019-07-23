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

  getTriggerListByJobId(schedulerName, jobGroup, jobName) {
    return new Promise(function (resolve) {
      Axios.get(PATH + '/scheduler-names/' + schedulerName + '/job-groups/' + jobGroup + '/job-names/' + jobName)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }

}
