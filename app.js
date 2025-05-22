const express = require('express');
const cors = require('cors');
const fileUpload = require('express-fileupload');
const bodyParser = require('body-parser');
let app = express();
app.use(cors());
app.use(fileUpload({}));
app.use(bodyParser.json({ limit: '100mb' }));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use('/statics', express.static('statics'));

const apiRouter = require('./router/api');
app.use('/services', apiRouter);

let server = app.listen(8002, function () {
    let host = server.address().address;
    let port = server.address().port;

    console.log("App listening at http://%s:%s", host, port);
});