<template>
    <div>
        <h1>Users</h1>
        <!-- <p>이 유저 현재 번호가 {{userId}} 입니다</p>
        {{ userId }}
        <h3>{{$route.query}}</h3>
        <h4>{{$route.query.group}}</h4> -->
        <p>유저를 검색해주세요</p>
    <v-flex xs12>
        <v-text-field 
        v-model="id"
        label="유저 번호를 입력하세요">
        </v-text-field>
        <v-btn
        @click="$router.push({
            name:'users-detail', 
            params: {
                id:id
        }})">검색</v-btn>
    </v-flex>
    <v-flex xs12>
        <router-view></router-view>
    </v-flex>
    </div>
</template>

<script>
export default {
    data() {
        return {
            id: null
        }
    },
    computed: {
        userId() {
            return this.$route.params.id
        },
    },
    created() {
        console.log('router', this.$router) // router.js를 의미
        console.log('route', this.$route) // 우리가 지정해준 params, query, path등을 의미
    }
}
</script>