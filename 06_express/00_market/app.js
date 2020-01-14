var express = require('express');
// express 불러옴
var bodyParser = require('body-parser')
var app = express()
// localhost 3000으로 열거다!
app.listen(3000, function() {
    console.log('start!!');
}); // -- 비동기로 node는 동작하기 때문에 밑에 있는 console.log보다 나중에 실행됨
// 3000이라는 포트를 기반으로 실행됨
console.log('asdfasdfasf');
app.set('view engine', 'ejs') // view engine은 ejs로 할거야
// 위에게 먼저 실행됨! -- 동기적인 애가 먼저 실행되고
app.use(express.static('public')) // static을 public으로 기억한다는 의미
app.get('/', function(req, res){
    // res.send("<h1>hi friend!</h1>")
    res.sendFile(__dirname+"/public/main.htm")
})

app.get('/main', function(req, res) {
    res.sendFile(__dirname+'/public/main.htm')

})
// json으로 응답을 받을 때는 
app.use(bodyParser.json())
// encoding 이면 아스키 형태로 치환 urlencoded!
app.use(bodyParser.urlencoded({extended:true}))
app.post('/email_post', function(req, res) {
    // get의 응답: req.param('email') -- html의 form의 input tag의 name이 email이니까
    console.log(req.body.email) // post의 응답은 req.body
    // res.send(req.body.email) // res.send()는 app.post 내지는 app.get 내에 하나만 잇어야 한다
    res.render('email.ejs', {'email': req.body.email})
    
})

app.post('/ajax_send_email', function(req, res){
    console.log(req.body.email);
    var responseData = {'result':'ok', 'email':req.body.email}
    res.json(responseData);

})

