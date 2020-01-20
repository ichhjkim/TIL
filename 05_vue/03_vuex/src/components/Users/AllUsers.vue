<template>
  <div>
    <h1>All Users({{ $store.getters.allUsersCount}})</h1>
    <h3>Seoul Users: {{ countOfSeoul }}({{ percent }}%)</h3>
    <v-list two-line>
      <v-list-tile 
        v-for="(user, index) in $store.state.allUsers"
        :key="index"
        avatar
      >
        <v-list-tile-avatar color="grey lighten-3">
          <img :src="user.src">
        </v-list-tile-avatar>

        <v-list-tile-content>
          <v-list-tile-title v-html="user.name"></v-list-tile-title>
          <v-list-tile-sub-title>id:#{{index}} / {{user.address}} 거주</v-list-tile-sub-title>
        </v-list-tile-content>
      </v-list-tile>
    </v-list>

  </div>
</template>

<script>
import { EventBus } from '@/main.js'
// @ == src 폴더를 의미함
import {mapState, mapGetters} from  'vuex' // mapGetters는 vuex에서 미리 선언해둔 것
// mapState 는 vuex의 state를 다 불러오겠다는 의미
export default {
    data() {
      return {
        
      }
    },
    computed: {
      ...mapGetters({
        count: 'allUsersCount',
        seouls: 'countOfSeoul',
        percent: 'percentOfSeoul' // --> 이렇게 해당 함수를 새로운 변수로 object에서 정의해서 간단하게 사용할 수 있다
      }),
      ...mapState(['allUsers']) // --> {{ allUsers }} 로 간단히 사용 가능 $store.state.allUsers 안해도 됨
      // store에서 사용할 getters 함수를 string으로 불러옴 --> 이렇게 하면 변수명 그 자체로 template에서 사용할 수 있다
      // ...mapGetters(['allUsersCount', 'countOfSeoul', 'percentOfSeoul'])
    },
    mounted() {
      EventBus.$on('signUp', user => {
        this.allUsers.push(user)
      })
    },

  } 
</script>
