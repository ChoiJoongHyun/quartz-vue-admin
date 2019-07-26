import {Message, MessageBox} from "element-ui";

export default {

  error(error) {
    if(error.response.status === 401) {
      window.location.href = window.location.origin + "/";
    } else {
      const errorMessage = error.response.data;
      MessageBox.alert(errorMessage, {type: 'error', dangerouslyUseHTMLString: true});
    }
  }
}
