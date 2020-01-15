var express = require('express');
var app = express();
var router = express.Router();
var mysql  =require('mysql');
var cors = require('cors');
var passport = require('passport');
var LocalStrategy = require('passport-local').Strategy;
var flash = require('connect-flash')

var connection = mysql.createConnection({

    host: 'localhost',
    port:3000,
    user:'root',
    password:'asdf1234',
    database: 'jsman'
    
    })
connection.connect();

router.get('/', function(req, res) {
    var errMsg = req.flash('error')
    if(errMsg) msg = errMsg;
    console.log('get join url');
    res.render('join.ejs', {'message': msg});
})
// passport.serialize -->  session에 들어가는 값 poassportjs.com
passport.use('local-join', new LocalStrategy({
    usernameField: 'email',
    passwordField: 'password',
    passReqToCallback: true
    }, function(req, email, password, done){
        console.log('db에서 조회')
        //var query = connection.query() // db서 select해서 조회
    }
    ));

router.post('/', 
    passport.authenticate('local-join', {
    successRedirect: '/main',
    failureRedirect: '/join',
    failureFlash: true }
))

/*
router.post('/', function(req, res){
    var body = req.body;
    var email = body.email;
    var name = body.name;
    console.log(email);
})
*/
module.exports = router;