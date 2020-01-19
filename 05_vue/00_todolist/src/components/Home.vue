<template>
<v-container>
    <v-layout row wrap>
      <v-flex xs6>
        <List
            :listver=todoList
            @Change="Change"
            @listdelete="listdelete"
            ></List>
      </v-flex>
        <v-flex xs6>
            <ListAdd @listAdd="listAdd">
              
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
    }
  }
}
</script>