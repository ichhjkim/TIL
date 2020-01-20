<template>
    <div>
        <h1>유저 상세페이지</h1>
        <h2>유저 번호: {{userId}}</h2>
        <v-btn @click="edit">수정</v-btn>
    </div>
</template>

<script>
    export default {
        computed :
         {
            userId() {
                return this.$route.params.id
            }
         },
         methods: {
             edit() {
                 this.$router.push({name:'users-edit'})
             }
         }
    }

</script>