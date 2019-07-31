import ErrorHandler from './errorHandler';

const PATH = '/api/cron/triggers';

export default {

  getCronTriggerList() {
    return new Promise(function (resolve, reject) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  }
}
