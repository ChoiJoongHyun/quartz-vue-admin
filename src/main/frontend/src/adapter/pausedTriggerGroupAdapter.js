import ErrorHandler from './errorHandler';

const PATH = '/api/paused-trigger-groups';

export default {

  getPausedTriggerGroupList() {
    return new Promise(function (resolve, reject) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  }
}
