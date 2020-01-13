var express = require('express');
// express 불러옴
var app = express()
// localhost 3000으로 열거다!
app.listen(3000, function() {
    console.log('start!');
}); // -- 비동기로 node는 동작하기 때문에 밑에 있는 console.log보다 나중에 실행됨
// 3000이라는 포트를 기반으로 실행됨
console.log('asdfasdfasf');
// 위에게 먼저 실행됨! -- 동기적인 애가 먼저 실행되고