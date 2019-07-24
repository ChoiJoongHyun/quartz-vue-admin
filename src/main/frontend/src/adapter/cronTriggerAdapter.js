import ErrorHandler from './errorHandler';

const PATH = '/api/cron/triggers';

export default {

  getCronTriggerList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }
}
