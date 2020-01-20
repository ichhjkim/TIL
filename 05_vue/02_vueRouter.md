# vueRouter

main.js에서 import 해주고

new vue 안에 route라고 해주어야 함

## 00_mode

mode: history

- history: #가 안들어감
- hash: #가 url에 들어감. 기본 mode



## 01_Routes - router.js

name으로 호출하는게 편함

```js
import Router from 'vue-router'


Vue.use(Router)

const Users = () => import(/* webpackChunkName: "about" */ './views/Users.vue')
const UsersDetail = () => import(/* webpackChunkName: "about" */ './views/UsersDetail.vue')
const UsersEdit = () => import(/* webpackChunkName: "about" */ './views/UsersEdit.vue')

export default new Router({
    mode:'history',
    base: process.env.BASE_URL,
    routes : [
        {
            path: '/users',
            name: 'users',
            component: Users
            children : [
            { // users/12341234/ 이런식으로 하위 url 붙을 때
                path: ':id',
                name: 'users-detail',
                component: UsersDetail
        }
            ]
        }
    ]
                          })
```



## 02_Router -> vue파일에서 호출

```vue
  <v-list-tile router :to="{name:'home'}" exact> --> exact는 딱 그 url로 들어갈 수 있게 함
          <v-list-tile-action>
            <i class="fas fa-home"></i>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>Home</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

```



param을 넣어서 보낼 수 도 잇다

```vue
 <v-list-tile router :to="{
           name:'users',
           params: {
             id: 'asdfasdf' // 숨기고 싶은 정보가 있을 때 사용
           },
           query: {
             group: 'member' --> ?query=asldkfjasl 처럼 ?뒤에 붙는 애들
           }
           }" exact>
           <!-- query는 주소창으로 하던 파라미터로 하든 상관 노노 -->
           <!-- params를 보내주는 방법으로 url이동 -->
          <v-list-tile-action>
```



## 03_router과 route의 차이 

$router은 router.js의 내용 그 자체

$route는 해당 url에 있는 params, query등의 정보