<?php
 
error_reporting(0);
 
$db_name = "u138200537_db";
$mysql_user = "u138200537_root";
$mysql_pass = "edu123";
$server_name = "mysql.hostinger.in";
 
$con = mysqli_connect($server_name, $mysql_user, $mysql_pass, $db_name);
 
if(!$con){
    echo '{"message":"Unable to connect to the database."}';
}
 
?>