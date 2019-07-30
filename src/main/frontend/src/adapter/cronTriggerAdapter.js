import ErrorHandler from './errorHandler';

const PATH = '/api/cron/triggers';

export default {

  getCronTriggerList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  },

  /**
   * @param cronExpression {string} default ''
   * */
  checkCronExpression(cronExpression = '') {
    return new Promise(function (resolve) {
      Axios.get(PATH + '/cron-expression-check' + '?cronExpression=' + cronExpression)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  },

  /**
   * @param triggerId {object}
   * @param cronExpression {string} default ''
   * */
  putCronExpression(triggerId, cronExpression = '') {
    return new Promise(function (resolve) {
      Axios.put(PATH + '/scheduler-names/' + triggerId.schedulerName + '/trigger-groups/' + triggerId.triggerGroup + '/trigger-names/' + triggerId.triggerName, { cronExpression : cronExpression })
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }
}
