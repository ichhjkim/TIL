import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import router from './router'
import store from './store' // 얘를 설정해주어야함

Vue.config.productionTip = false

export const EventBus = new Vue()

new Vue({
  router,
  store, // 하나의 값으로 이미 들어가있음
  render: h => h(App)
}).$mount('#app')
