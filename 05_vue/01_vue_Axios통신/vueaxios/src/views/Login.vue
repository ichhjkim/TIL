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
export default {

}
</script>

<style>

</style>