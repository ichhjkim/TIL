import React, {Component} from 'react';
import MyName from './MyName'
import Counter from './Counter'
import PhoneForm from './components/PhoneForm'

class App extends Component {
  id=0; // 굳이 state에 넣어주지 않아도 됨
  state= {
    information: [],

  }
  handleCreate = (data) => {
    this.setState({
      information: this.state.information.concat({
        ...data,
      id : this.id++
      })
      // react는 불변성이 기본이기 떄문에 concat을 사용해서 새로운 배열을 만든후 주입해야함
      // ...data, id: this.id++ --> data가 추가될때마다 아이디 하나씩 올리기
    })
  }
  render() {
    return (

      <div>
        <MyName name="ichhjkim" />
        <Counter />
        <hr/>
        <hr/>
        <PhoneForm onCreate={this.handleCreate}/>
        {JSON.stringify(this.state.information)}
      </div>
    );
  }
}

export default App;
