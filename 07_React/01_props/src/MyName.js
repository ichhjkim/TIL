import React, {Component} from 'react';

class MyName extends Component {
    static defaultProps = {
        name: '기본이름'
    } // this.props.name의 기본값을 설정할 수 있음
    render() {
        return (
            <div>
                안녕하세요! 제 이름은 {this.props.name} 입니다.
            </div>
        )
    }
}

/* 컴포넌트를 만들때 클래스로 만들수도 있지만, 
이렇게 함수 컴포넌트를 만들 수 있음, 그럼 위에서 {Component} 를 불러오지 않아도 됨
이렇게 하면 더 코드를 간결하게 짤 수 있다
초기 마운트 속도가 미세하게 빠르고
메모리도 덜 차지
-> 단, state, lifecycle이 없다.

    const MyName = ({name}) => {
        return (
            <div> 안녕하세요 제 이름은 {name}입니다
            </div>
        );
    };
    MyName.defaultProps = {
        name: '기본이름'
    }

*/
/* 
function sayHello({name, age}) {
    console.log(name+age);
}
==> sayHello({name: '리액트', age:"몰라"});
--> {} 객체 내부의 name, age 값을 가져오는 것
*/

export default MyName