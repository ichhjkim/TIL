var express = require('express');
var app = express();
var router = express.Router();
var path = require('path');
var main = require('./main/main.js')
var email = require('./email/email')
var join = require('./join/index');

router.get('/', function(req, res){
    res.sendFile(path.join(__dirname, '../public/main.htm'))
});
router.use('/main', main)
router.use('/email', email)
router.use('/join', join)

module.exports = router;