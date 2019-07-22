import ErrorHandler from './errorHandler';

const PATH = '/api/simple/triggers';

export default {

  getSimpleTriggerList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }

}

