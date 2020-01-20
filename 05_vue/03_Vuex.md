# 03_Vuex



중앙 집중식 저장소 역할을 하여 예측가능한 방식으로 상태를 변경할 수 있다

store.js -> 디아블로의 상자 개념



vuex는 중앙 집중식 저장소 역할을 하기 때문에 설정을 할 때도 중앙 관리소 역할을 하는 main.js에서 설정을 한다

store.js

```js
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state ....
})
```



## 01_state



state는 일반 vue 파일에서 data 역할을 한다

```js
export default new Vuex.Store({
    state : {
    	allUsers: [
            {userId: 'hoza', pw: '1234', name:'안뇽', address:"Seoul"}
        ]
    }
})
```



allUsers.vue -> **일반 vue 파일에서 state의 allUsers를 받아서 쓸때**

방법 1. 

`{{ $store.state.allUsers }}`

방법 2.

`import {mapState} from 'vuex'`



```vue
export default {
	data() {
		return {
		
		}
	},
    computed: {
        ...mapState(['allUsers']) 
    }
}
```



`{{ allUsers }}` 라고 부르는게 가능





## 02_Getters

vuex 의 `computed`같은 것

이 안에서 state 값을 불러와서 쓸 때, state를 써줘야함

```js
getters: {
	allUserCount: function(state) {
		return state.allUsers.length // this. == state.
	},
     percentOfSeoul :(state, getters) { // getters만 써도 state를 같이 써주어야함
         return Math.round(getters.countOfSeoul/getters.allUsersCount*100)
     } // getters꺼를 갖다가 쓸떄는 `getters.변수 이름`
}
```



allUsers.vue

```js
import {mapState, mapGetters} from  'vuex'

export default {
    data() {
      return {
        
      }
    },
    computed: {
      ...mapGetters({
        count: 'allUsersCount',
        seouls: 'countOfSeoul',
        percent: 'percentOfSeoul' // --> 이렇게 해당 함수를 새로운 변수로 object에서 정의해서 간단하게 사용할 수 있다 ==> {{count}} | {{seouls}} | {{percent}} 이렇게 씀
      }),
      ...mapState(['allUsers']) // --> {{ allUsers }} 로 간단히 사용 가능 $store.state.allUsers 안해도 됨
      // store에서 사용할 getters 함수를 string으로 불러옴 --> 이렇게 하면 변수명 그 자체로 template에서 사용할 수 있다
      // ...mapGetters(['allUsersCount', 'countOfSeoul', 'percentOfSeoul'])
        ==> {{allUserCount}} | {{ countOfSeoul }} | {{percentOfSeoul}}
    },
```



## 03_mutations

mutations 에 있는 함수를 사용해서 commit 해서 state의 값을 바꿈

```js
  mutations: {
    //mutations에 있는 함수를 사용해서 commit해서 state의 값을 바꿈
    addUsers: (state, payload) => {
      // 회원가입할 때 입력되는 애들 가져온 값을 넘겨주는 역할
      state.allUsers.push(payload) // --> user이 될 것
    }
  },
```

방법 1

` // ...mapMutations(['addUsers']),`

-->  // 2. this.addUsers(userObj) // 밑에 eventBus를 대체



방법 2

 store의 mutation을 실행시킬 때는 이렇게 

​    // this.$store.`commit`('addUsers', userObj) // userObj === payload



## 04_actions

```js
 actions : {
      // state를 변화시키는 것은 mutations
      // 비즈니스 로직과 관련된 것은 actions
      // dispatch --> action 실행 | commit ---> mutations
      // addUsers: context => {
      //   context.commit('addUsers')
      // }
      addUsers: ({commit}, payload) => {
        // 실제 코드를 구현할 때는 
        // 이 사이에 엄청 막 이런 저런 코드가 있을 것
        // 그 코드 로직을 다 실현후에 commit을 실현시켜!의 의미
        commit('addUsers', payload)
```



방법 1

​    // this.$store.`dispatch`('addUsers', userObj) 

방법 2

   ...mapActions(['addUsers']),

​    this.addUsers(userObj)