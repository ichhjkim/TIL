var express = require('express');
var app = express();
var router = express.Router();
var path = require('path')
var cors = require('cors');

app.use(cors());

router.post('/form', function(req, res) {
    // get의 응답: req.param('email') -- html의 form의 input tag의 name이 email이니까
    console.log(req.body); // post의 응답은 req.body
    // res.send(req.body.email) // res.send()는 app.post 내지는 app.get 내에 하나만 잇어야 한다
    res.render('email.ejs', {'email': req.body})
    
})


router.post('/ajax', function(req, res){
    
    var user = console.log(req.body.user);
    var responseData = {};
    var query = connection.query('select user from tables_in_jsman', function(err, rows) {
        if (err) throw err;
        if (rows[0]) {
            console.log(rows[0]);
            responseData.result="ok";
            responseData.user = rows[0].user;
        }
    })
    res.json(responseData);
})

module.exports = router;