import Vue from 'vue';
import App from './App.vue';

import '@/filter';

import router from './router';

/* element-ui install */
import 'element-ui/lib/theme-chalk/index.css';
import Element from 'element-ui';
import ElementLocale from 'element-ui/lib/locale';
import ElementKorean from 'element-ui/lib/locale/lang/ko';
ElementLocale.use(ElementKorean);
Vue.use(Element);

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
