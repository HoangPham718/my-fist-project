<?php
require_once('lib/db.php');
$r=DP::run_query('SELECT * FROM `tuvung` LIMIT 5','',2);
echo json_encode($r); 

?>