<?php
require_once('lib/db.php');
$TuKhoa=$_GET['Tim'];
$r=DP::run_query("SELECT * FROM `tuvung` Where tuvung LIKE '%$TuKhoa%' LIMIT 5",'',2); 
echo json_encode($r); 
?>