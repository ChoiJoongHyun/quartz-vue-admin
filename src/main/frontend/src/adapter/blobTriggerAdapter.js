import ErrorHandler from './errorHandler';

const PATH = '/api/blob/triggers';

export default {

  getBlobTriggerList() {
    return new Promise(function (resolve) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch(ErrorHandler.error)
    });
  }

}
