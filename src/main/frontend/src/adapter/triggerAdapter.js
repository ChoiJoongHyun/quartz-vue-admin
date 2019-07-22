import ErrorHandler from './errorHandler';

const PATH = '/api/triggers';

export default {

  getTriggerList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }

}
