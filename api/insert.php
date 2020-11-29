<?php
require_once('lib/db.php');//tập tin kết nối dữ liệu

$id=$_POST['id'];
$word=$_POST['word'];
$def=$_POST['def'];
$verb=$_POST['verb'];

$r=DP::run_query("INSERT INTO `dictonary` VALUES('$id','$word','$def','$verb')",'',1);

if($r!=false)
	echo "true";
else
	echo "false";
?>