<template>

<v-container>
  <v-flex xs 12 text-xs-center>
    <h1>Todo List</h1>
  <p>전체 할일: {{todoList.length}}</p>
  <p>완료된 할일:{{countDone}}</p>
  <p>남은 할일 : {{todoList.length-countDone}}</p>
    </v-flex>
    <v-layout row wrap>
      <v-flex xs6>
        <List
            :listver=todoList
            @Change="Change"
            @listdelete="listdelete"
            ></List>
      </v-flex>
        <v-flex xs6>
            <ListAdd 
            @listEdit="listEdit"
            @listAdd="listAdd">
              
              </ListAdd> 
        </v-flex>
  </v-layout>
</v-container>
</template>

<script>
import List from './List'
import ListAdd from './ListAdd'

export default {
  data() {
    return {
      todoList: []
    }
  },
  components: {
    List,
    ListAdd,
  },
  methods: {
    listAdd(memo) {
      console.log("받았어!")
      // 객체 형태로 todoList에 push 하는 것
      this.todoList.push({ memo: memo, status: "created" })
    },
    Change(index, status){
      this.todoList[index].status= status
    },
    listdelete(index){
      this.todoList.splice(index, 1);
      // 1개 만 지워죠
    },
    listEdit(memo, index) {
      this.todoList[index].memo = memo
    }
  },
  computed: {
    countDone() {
      let count = 0
      this.todoList.forEach(list=> {
        if (list.status ==='done') count++;
      })
      return count
    }
  }
}
</script>