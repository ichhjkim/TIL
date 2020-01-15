var express = require('express');

var app = express();

var router = app.Router();

// 이젠 app 대신 router 로!
router.get('/main', function(req, res) {
    res.sendFile(__dirname+'/public/main.htm')

})

module.exports = router; // 이제 다른 파일에서 main.js router를 쓸 수 있도록 함 