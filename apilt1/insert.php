<?php
$connect=mysqli_connect("localhost","root","","dictonary");
mysqli_query($connect,"SET NAMES 'utf-8'");
	
	$tu=$_GET['tu'];
 	$dn=$_GET['dn'];

 	$query="INSERT INTO tuvung VALUES ('$tu','$dn')";
 if (mysqli_query($connect, $query)) {
 	echo "success";
 }
 else
 	echo "error";
?>