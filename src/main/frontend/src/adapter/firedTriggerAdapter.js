import ErrorHandler from './errorHandler';

const PATH = '/api/fired/triggers';

export default {

  getFiredTriggerList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }
}
