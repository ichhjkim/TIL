var express = require('express');
var bodyParser = require('body-parser')
var app = express();
var mysql  =require('mysql');
var router = require('./router/index')
var cors = require('cors');
var passport = require('passport');
var LocalStrategy = require('passport-local').Strategy;
var session = require('express-session');
var flash = require('connect-flash')

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



//passport 관련 내용

app.use(session({
    secret : 'keyboard cat',
    resave : false,
    saveUninitialized: true
}));
app.use(passport.initialize())
app.use(passport.session())
app.use(flash())

app.use(router); // 얘가 가장 마지막에 있어야 오류가 나지 않는다