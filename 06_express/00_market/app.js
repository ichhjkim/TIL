var express = require('express');
// express 불러옴
var app = express()
// localhost 3000으로 열거다!
app.listen(3000, function() {
    console.log('start!!');
}); // -- 비동기로 node는 동작하기 때문에 밑에 있는 console.log보다 나중에 실행됨
// 3000이라는 포트를 기반으로 실행됨
console.log('asdfasdfasf');
// 위에게 먼저 실행됨! -- 동기적인 애가 먼저 실행되고
app.use(express.static('public')) // static을 public으로 기억한다는 의미
app.get('/', function(req, res){
    // res.send("<h1>hi friend!</h1>")
    res.sendFile(__dirname+"/public/main.htm")
})

app.get('/main', function(req, res) {
    res.sendFile(__dirname+'/public/main.htm')
})


