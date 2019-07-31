import ErrorHandler from './errorHandler';

const PATH = '/api/scheduler-state';

export default {

  getSchedulerStateList() {
    return new Promise(function (resolve, reject) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  }
}
