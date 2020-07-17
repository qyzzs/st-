import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
// 导入全局样式
import './assets/css/global.css'
// import axios from 'axios'
import { postRequest, postKeyValueRequest, putRequest, deleteRequest, getRequest } from './utils/api'

Vue.config.productionTip = false
Vue.prototype.postRequest = postRequest
Vue.prototype.postKeyValueRequest = postKeyValueRequest
Vue.prototype.putRequest = putRequest
Vue.prototype.deleteRequest = deleteRequest
Vue.prototype.getRequest = getRequest

// axios.defaults.baseURL = 'http://localhost:8077/'
// Vue.prototype.$http = axios

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
