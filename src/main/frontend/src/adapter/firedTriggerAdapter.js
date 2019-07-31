import ErrorHandler from './errorHandler';

const PATH = '/api/fired/triggers';

export default {

  getFiredTriggerList() {
    return new Promise(function (resolve, reject) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  }
}
