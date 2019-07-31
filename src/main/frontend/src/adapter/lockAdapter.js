import ErrorHandler from './errorHandler';

const PATH = '/api/locks';

export default {

  getLockList() {
    return new Promise(function (resolve, reject) {
      Axios.get(PATH)
        .then(res => resolve(res.data))
        .catch((error) => ErrorHandler.error(error, reject))
    });
  }
}
