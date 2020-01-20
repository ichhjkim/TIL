import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
// vuex의 computed 역할이 : getters
export default new Vuex.Store({
  state: { // data 역할
    allUsers:[
      {userId: 'hoza123', password: '123', name: 'Hoza', address: 'Seoul', src:'https://goo.gl/oqLfJR'},
      {userId: 'max123', password: '456', name: 'Max', address: 'Berlin', src:'https://goo.gl/Ksk9B9'},
      {userId: 'lego123', password: '789', name: 'Lego', address: 'Busan', src:'https://goo.gl/x7SpCD'}
    ]
  },
  getters: {
    // getters는 vuex의 computed같은 것
    // 이 안에서 state값을 불러와서 쓸때, state를 써줘야함
    allUsersCount : function(state) {
      return state.allUsers.length
    },
    countOfSeoul : state => {
      let count = 0
      state.allUsers.forEach(user => {
        if(user.address ==="Seoul") count++;
      })
      return count
    },
    // getters 내용만 써도 앞에 state를 꼭 써 주어야 함
    percentOfSeoul: (state, getters) => {
      return Math.round(getters.countOfSeoul/getters.allUsersCount*100)
    }
  },
  mutations: {
    //mutations에 있는 함수를 사용해서 commit해서 state의 값을 바꿈
    addUsers: (state, payload) => {
      // 회원가입할 때 입력되는 애들 가져온 값을 넘겨주는 역할
      state.allUsers.push(payload) // --> user이 될 것
    }
  },
    // 비동기와 동기가 섞였을 때 어떤 순서로 작동하는지 파악하기 어렵기 때문에 
    // actions를 사용하는 것
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
        
      }
    }
})
