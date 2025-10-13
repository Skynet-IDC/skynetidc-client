const express = require('express');
// const swagger = require("swagger-generator-express");
//
// const options = {
//     title: "swagger-generator-express",
//     version: "1.0.0",
//     host: "localhost:3000",
//     basePath: "/",
//     schemes: ["http", "https"],
//     securityDefinitions: {
//         Bearer: {
//             description: 'Example value:- Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjU5MmQwMGJhNTJjYjJjM',
//             type: 'apiKey',
//             name: 'Authorization',
//             in: 'header'
//         }
//     },
//     security: [{Bearer: []}],
//     defaultSecurity: 'Bearer'
// };

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

const apiRouter = require('./router/routes');
// swagger.serveSwagger(app, "/swagger", options, {routePath : './router/', requestModelPath: './request', responseModelPath: './response'});

app.use('/services', apiRouter);

let server = app.listen(8002, function () {
    let host = server.address().address;
    let port = server.address().port;

    console.log("App listening at http://%s:%s", host, port);
});