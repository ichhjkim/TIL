import React, {Component} from 'react';

class Counter extends Component {
    state = {
       number: 1
    }
    // state는 객체여야 함, vue의 data 같은애
    handleIncrease = () => {
        //this.state.number++; 
        // 이렇게 하면 컴포넌트가 이 state가 업데이트 되었는지를 모름 이렇게 쓰면 안됨
        this.setState({
            number: this.state.number+1
        })
    }
    /* 왜 화살표 함수로 작성하냐면, 함수가 this를 인식하지 못함
       constructor(props) {
           super(props);
           this.handleIncreate = this.handleIncreate.bind(this);
           
       }
       이런 식으로 constructor 함수에서 선언을 해주어야 함
       귀찮으니 그냥 화살표 함수를 쓰자
    */
    handleDecrease = () => {
        //this.state.number++; 
        // 이렇게 하면 컴포넌트가 이 state가 업데이트 되었는지를 모름 이렇게 쓰면 안됨
        this.setState({
            number: this.state.number-1
        })
        // 이렇게 해야 component가 rerendering 됨!
    }
    render() {
        return (
            <div>
                <h1>카운터</h1>
                <div>값 : {this.state.number}</div>
                <button onClick={this.handleIncrease}>+</button>
                <button onClick={this.handleDecrease}>-</button>
            </div>
        )
    }
}

export default Counter