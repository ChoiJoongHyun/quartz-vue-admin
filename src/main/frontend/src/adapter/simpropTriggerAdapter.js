import ErrorHandler from './errorHandler';

const PATH = '/api/simprop/triggers';

export default {

  getSimpropTriggerList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }

}
