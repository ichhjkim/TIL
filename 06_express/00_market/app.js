var express = require('express');
var bodyParser = require('body-parser')
var app = express();
var mysql  =require('mysql');
var router = require('./router/index')
var cors = require('cors');
app.use(cors());

app.listen(3000, function() {
    console.log('start!!');
}); 

var connection = mysql.createConnection({

    host: 'localhost',
    port:3000,
    user:'root',
    password:'asdf1234',
    database: 'jsman'
    
    })
connection.connect();

app.set('view engine', 'ejs') // view engine은 ejs로 할거야
// 위에게 먼저 실행됨! -- 동기적인 애가 먼저 실행되고
app.use(express.static('public')) // static을 public으로 기억한다는 의미
// json으로 응답을 받을 때는 
app.use(bodyParser.json())
// encoding 이면 아스키 형태로 치환 urlencoded!
app.use(bodyParser.urlencoded({extended:true}))
app.use(router);




