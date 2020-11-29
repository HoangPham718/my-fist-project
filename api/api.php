<?php
require_once('lib/db.php');//tập tin kết nối dữ liệu
$r=DP::run_query('SELECT * FROM `Dictonary`','',2); //Truy vấn lấy về danh sách câu hỏi
echo json_encode($r); //Trả về danh sách câu hỏi dưới dạng mảng jSon

?>