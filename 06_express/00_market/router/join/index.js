var express = require('express');
var app = express();
var router = express.Router();
var mysql  =require('mysql');
var cors = require('cors');

var connection = mysql.createConnection({

    host: 'localhost',
    port:3000,
    user:'root',
    password:'asdf1234',
    database: 'jsman'
    
    })
connection.connect();

router.get('/', function(req, res) {
    console.log('get join url');
    res.sendFile(path.join(__dirname, '../../public/join.htm'))
})
router.post('/', function(req, res){
    var body = req.body;
    var email = body.email;
    var name = body.name;
    console.log(email);
})
module.exports = router;