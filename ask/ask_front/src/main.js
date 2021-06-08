// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import router from './router'
import axios from 'axios'
import { getCookie, isEmpty, isNotEmpty } from './utils/util'

Vue.prototype.axios = axios

Vue.use(ElementUI)

Vue.config.productionTip = false

Vue.prototype.isEmpty = isEmpty
Vue.prototype.isNotEmpty = isNotEmpty
Vue.prototype.getCookie = getCookie

router.beforeEach((to, from, next) => {
  // 判断该路由是否需要登录权限
  if (to.matched.some(record => record.meta.requireAuth)) {
    // 判断当前的userId是否存在，登录存入的userId
    if (getCookie('userId')) { 
      next()
    }
    else {
      next({
        path: '/login',
        // 将要跳转路由的path作为参数，传递到登录页面
        query: {redirect: to.fullPath}
      })
    }
  }
  else {
    next()
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
