var express = require('express');
var app = express();
var router = express.Router();
var mysql = require('mysql')
var cors = require('cors')
var passport = require('passport')
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
    res.render('login.ejs', {'message': msg});
})
passport.serializeUser(function(user, done){
    console.log('passport session save')
    done(null, user.id)
})

passport.deserializeUser(function(id, done){
    done(null, id);
})
passport.use('local-login', new LocalStrategy({
    usernameField: 'email',
    passwordField: 'password',
    passReqToCallback: true

    }, function(req, email, password, done){
        console.log('db에서 조회')
        return done(null, {'email':email, 'id': rows.insertId})
        //var query = connection.query() // db서 select해서 조회
    }
    ));

router.post('/', function(req, res, next){
    passport.authenticate('local-login', function(err, user, info){
        if(err) res.status(500).json(err);
        if (!user) {return res.status(401).json(info.message);} // json 형식으로 주어야 ajax로 데이터를 주고 받을 수 있다
    })
    req.logIn(user, function(err){
        if (err) {return next(err)}
        return res.json(user);
    })(req, res, next);
}
)


module.exports = router;