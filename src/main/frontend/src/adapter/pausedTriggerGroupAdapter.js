import ErrorHandler from './errorHandler';

const PATH = '/api/paused-trigger-groups';

export default {

  getPausedTriggerGroupList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }
}
