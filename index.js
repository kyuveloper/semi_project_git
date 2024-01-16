// const mysql = require('mysql2')
// const express = require('express')
// const cors = require('cors')
// const bodyParser = require('body-parser')
// const app = express()
// app.use(cors());
// app.use((req, res, next) => {
//     res.header('Access-Control-Allow-Origin', '*'); // 모든 도메인에서 접근 허용 (보안 측면에서는 '*' 대신 실제 도메인을 지정하는 것이 좋음)
//     res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
//     res.header('Access-Control-Allow-Headers', 'Content-Type');
//     // 실제 서비스에서는 위와 같은 헤더 외에도 필요한 헤더를 추가할 수 있다.
//     next();
// });
//
// const connection = mysql.createConnection({
//     host : '222.112.124.237',
//     user : 'pettales',
//     password : 'pettales',
//     database : 'pettales'
// })
// console.log('Connected Database')
//
// // app.set('view engine', 'ejs') // 아마 안쓸듯?
// // app.set('views', ',/views')
//
// app.use(bodyParser.json())
// app.use(bodyParser.urlencoded({extended: false}))
// app.use(express.static(__dirname + '/public'))
//
// app.get('/admin/anno', (req, res) => {
//     const annoSql = `SELECT ANNO_CODE, ANNO_TITLE, ANNO_CONTENTS, REGIST_DATE, UPDATE_DATE FROM ANNOUNCEMENT`
//     connection.query(annoSql, function (err, result, fields){
//         if (err) {
//             console.log('Announcement Error')
//             throw err;
//         }
//         res.json(result)
//     })
// })
// // app.put('/admin/annoEdit', (req, res) => {
// //     const annoEdit = req.query.ANNO_CODE
// //     const editSql = `UPDATE ANNOUNCEMENT SET ANNO_TITLE= ${annoTitle},ANNO_CONTENTS= ${annoContents},ANNO_PIN= ${annoPin},ANNO_STATUS= ${annoStatus},update_date=DATE_FORMAT(now(), '%Y-%m-%d') WHERE ANNO_CODE=${annoEdit}`
// //     connection.query(editSql, function (err, result){
// //         if (err) {
// //             console.log('Update Error')
// //             throw err
// //         }
// //         res.json({success: true})
// //     })
// // })
//
// app.get('/admin/inquiryList', (req, res) => {
//     const inquirySql = `SELECT * FROM INQUIRY`
//     connection.query(inquirySql, function (err, result, fields) {
//         if (err) {
//             console.log('Inquiry Error')
//             throw err;
//         }
//         res.json(result)
//     })
// })
//
// app.delete('/annoDelete', (req, res) => {
//     const annoDelete = req.query.ANNO_CODE
//     const delSql = `DELETE FROM ANNOUNCEMENT WHERE ANNO_CODE=${annoDelete}`
//     connection.query(delSql, function (err, result){
//         if (err) {
//             console.log('Delete Error')
//             throw err
//         }
//         res.json({success: true})
//     })
// })
//
// app.delete('/inquiryDelete', (req, res) => {
//     const inquiryDelete = req.query.INQ_CODE
//     const delSQL = `DELETE FROM INQUIRY WHERE INQ_CODE=${inquiryDelete}`
//     connection.query(delSQL, function (err, result){
//         if (err) {
//             console.log('Delete Error')
//             throw err
//         }
//         res.json({success: true})
//     })
// })
//
// const port = 3000
// app.listen(port, () => {
//     console.log(`Port on ${port}`)
// })
