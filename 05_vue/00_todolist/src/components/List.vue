<template>
<div>
    <v-card
    class="pa-3"
    :class="{'done':list.status==='done'}"
     v-for="(list, index) in listver"
     :key="index">
     <!-- 바인들 할때, 오른쪽에 있는 값을 왼쪽으로 대입한다! 기억 -->
        <p v-if="list.status==='created'">{{list.memo}}</p>
        <p>{{list.status}}</p>
        <v-btn 
        v-if="list.status==='created'"
        @click="$emit('Change', index, 'done')"
        fab flat small green >완료</v-btn>
        <v-btn 
        v-else
        @click="$emit('Change', index, 'created')"
        fab flat small blue>부활</v-btn>
        <v-btn 
        @click="$emit('listdelete', index)"
        fab flat small red>제거</v-btn>
    </v-card>
</div>
</template>

<script>
import List from './List'
import ListAdd from './ListAdd'

export default {
    props: [
        "listver"
        ],

}
</script>

<style scoped>
.done {
    background-color: black;
}
.done p {
    text-decoration: line-through;
}
</style>