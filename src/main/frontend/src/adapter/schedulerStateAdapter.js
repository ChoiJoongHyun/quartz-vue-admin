import ErrorHandler from './errorHandler';

const PATH = '/api/scheduler-state';

export default {

  getSchedulerStateList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }
}