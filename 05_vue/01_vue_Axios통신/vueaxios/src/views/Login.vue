<template>
  <v-container fill-height style="max-width:450px">
      <v-layout align-center row wrap>
          <v-flex xs12>
            <v-alert
            class="mb-3"
            :value="isLoginError"
            type="error">
                아이디와 비밀번호를 확인해주세요
            </v-alert>
            <v-alert
            class="mb-3"
            :value="isLogin"
            type="success">
            로그인이 완료되었습니다.
            </v-alert>
            <v-card>
                <v-toolbar flat>
                <v-toolbar-title>로그인</v-toolbar-title>
                </v-toolbar>
                <div class="pa-3">
                    <v-text-field
                    v-model="email"
                    lable="이메일을 입력하세요"></v-text-field>
                <v-btn
                color="primary"
                depressed
                block
                large
                @click="login({email, password})">로그인</v-btn>
                <v-btn @click="test">테스트</v-btn>
                </div>
            </v-card>
          </v-flex>
      </v-layout>

  </v-container>
</template>

<script>
import {mapState, mapActions} from 'vuex'
import axios from "axios"

// const axios = require('axios'); === node.js 버젼

export default {
    data() {
        return {
            email: null,
            password: null
        }
    },
    computed: {
        ...mapState(['isLogin', 'isLoginError'])

    },
    methods: {
        ...mapActions(['login']),
        test () {
            axios
            .get('https://reqres.in/api/users?page=2')
            .then(res => {console.log(res);
                // 콜백함수에서 function()을 쓰게 되면 콜백함수 내를 의미하기 때문에
                // 애로우 func을 사용해야한다
            })
            .catch(err => {
                console.log(err);
            })
            .finally(() => {
            });
                    }
    }
}
</script>

<style>

</style>