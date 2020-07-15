import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
Vue.use(Router)

const router = new Router({
  routes: [
    { path: '/', redirect: '/login' },
    { path: '/login', component: Login },
    { path: '/home', component: Home }
  ]
})

// to 去哪儿
// from 从那来
// next 函数
router.beforeEach((to, from, next) => {
  if (to.path === '/login') {
    next()
  } else {
    const tokenStr = window.sessionStorage.getItem('token')
    if (!tokenStr) {
      next('/login')
    } else {
      next()
    }
  }
})
// 暴露 路由
export default router
