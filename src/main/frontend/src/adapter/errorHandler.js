import {Message, MessageBox} from "element-ui";

export default {

  error(error, reject) {
    if(error.response.status === 401) {
      window.location.href = window.location.origin + "/";
    } else {
      const data = error.response.data;
      MessageBox.alert(data.errorMsg, 'ERROR', {type: 'error', dangerouslyUseHTMLString: true});

      return reject(data.errorMsg);
    }
  }
}
