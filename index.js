const mysql = require('mysql2')
const express = require('express')
const multer = require('multer')
const cors = require('cors')
// const ejs = require('ejs')
const bodyParser = require('body-parser')
const app = express()
app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*'); // 모든 도메인에서 접근 허용 (보안 측면에서는 '*' 대신 실제 도메인을 지정하는 것이 좋음)
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    // 실제 서비스에서는 위와 같은 헤더 외에도 필요한 헤더를 추가할 수 있습니다.
    next();
});
const port = 3000
const connection = mysql.createConnection({
    host : '222.112.124.237',
    user : 'pettales',
    password : 'pettales',
    database : 'pettales'
})
console.log('Connected Database')

// app.set('view engine', 'ejs') // 아마 안쓸듯?
// app.set('views', ',/views')
// app.use(cors());
// app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}))
app.use(express.static(__dirname + '/public'))


app.get('/map',(req, res) => {
    const mapSql = `SELECT COMPANY_CODE, COMPANY_NAME, COMPANY_LAT, COMAPNY_HAR FROM COMPANY_TABLE`
     const markerSql = `SELECT ct.COMPANY_CODE, ct.COMPANY_NAME, ct.COMPANY_LAT, ct.COMAPNY_HAR FROM company_table ct JOIN bookmark_table bt ON ct.COMPANY_CODE = bt.COMPANY_CODE`
     connection.query(mapSql, function (err1, mapSql, fields1) {
         if (err1) {
             console.log('Map Error 1')
             throw err1
         }
         connection.query(markerSql, function (err2, markerSql, fields2) {
             if (err2) {
                 console.log('Marker Error 2')
                 throw err2
             }
             const Sqls = {
                 mapSql: mapSql,
                 markerSql: markerSql
             }
             res.json(Sqls)
         })
     })
    // connection.query(mapSql, function (err, result, fields){
    //     if (err) {
    //         console.log('Map Error');
    //         throw err;
    //     }
    //     res.json(result);
    // })
})

app.get('/anno', (req, res) => {
    const annoSql = `SELECT ANNO_CODE, ANNO_TITLE, ANNO_CONTENTS, REGIST_DATE, UPDATE_DATE FROM ANNOUNCEMENT`
    connection.query(annoSql, function (err, result, fields){
        if (err) {
            console.log('Announcement Error')
            throw err;
        }
        res.json(result)
    })
})

// app.post('/insertAnno',  (req, res) => { 일단 원래 방식으로 구현..
//     console.log('hihi')
//     console.log(req.body)
//     const title = req.body.title
//     const contents = req.body.contents
//     const annoPin = req.body.annoPin
//     const annoStatus = req.body.annoStatus
//
//     const insertSql =
//         `INSERT INTO ANNOUNCEMENT(ANNO_CODE, ANNO_TITLE, ANNO_CONTENTS, ANNO_PIN, ANNO_STATUS, REGIST_DATE, UPDATE_DATE, USER_CODE) VALUES(NULL, '${title}', '${contents}', '${annoPin}', '${annoStatus}', now(), now(), '1')`
//
//     connection.query(insertSql, function (err, result, fields){
//         if (err) {
//             console.log('Insert Error')
//             throw err
//         }
//         console.log('Inserted Announcement')
//         res.send("" + "<script> alert('공지 등록이 완료되었습니다.'); location.href='/';</script>")
//     })
// })
app.delete('/annoDelete', (req, res) => {
    const annoDelete = req.query.ANNO_CODE
    const delSql = `DELETE FROM ANNOUNCEMENT WHERE ANNO_CODE=${annoDelete}`
    connection.query(delSql, function (err, result){
        if (err) {
            console.log('Delete Error')
            throw err
        }
        res.json({success: true})
    })

})

app.listen(port, () => {
    console.log(`Port on ${port}`)
})