import {Message, MessageBox} from "element-ui";

export default {

  error(error) {
    if(error.response.status === 401) {
      window.location.href = window.location.origin + "/";
    } else {
      const responseData = error.response.data;
      MessageBox.alert(`<strong> ${responseData.globalError.message} </strong>`,responseData.globalError.code, {type: 'error', dangerouslyUseHTMLString: true});
    }
  }
}
