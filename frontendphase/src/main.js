import Vue from 'vue'
import App from './App.vue'
import router from './routes' //router
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import Toasted from 'vue-toasted';

Vue.config.productionTip = false
Vue.use(BootstrapVue)
Vue.use(Toasted)

new Vue({
  router, //router
  render: h => h(App),
}).$mount('#app')
