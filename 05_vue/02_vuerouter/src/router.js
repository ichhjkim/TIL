import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)
const About = () => {
  return import(/* webpackChunkName: "about" */ './views/About.vue')
}
const Users = () => import(/* webpackChunkName: "about" */ './views/Users.vue')
const UsersDetail = () => import(/* webpackChunkName: "about" */ './views/UsersDetail.vue')
const UsersEdit = () => import(/* webpackChunkName: "about" */ './views/UsersEdit.vue')

export default new Router({
  mode: 'history',
  //history 모드 : # 기호가 들어감. hashmode가 됨
  // 
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
    
      name: 'about-name',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited. ==> 기본적으로 vue.js
      component: About
    },
    {
      path: '/users',
      // path: '/users/:id', // 주소창 입력으로 params를 받는 방법
      name: 'users',
      component: Users,
      children: [
        {
          path: ':id',
          name: 'users-detail',
          component: UsersDetail
        },
        {
          path: ':id/edit',
          name: 'users-edit',
          component: UsersEdit
        }
      ]
    }
  ]
})
// ? 뒤에 뜨는 것을 쿼리라고 함
