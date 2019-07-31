import ErrorHandler from './errorHandler';

const PATH = '/api/blob/triggers';

export default {

  getBlobTriggerList() {
    return new Promise(function (resolve, reject) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  }

}
