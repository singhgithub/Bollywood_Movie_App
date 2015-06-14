

<?php   // working with my laptop server
$conn_error = 'Could not connect. ';
$mysql_user = 'root';
$mysql_host = 'localhost';		//IP address of raspberry pi 
$mysql_pass = '';

$mysql_db = 'movies_2014';
if (!mysql_connect($mysql_host, $mysql_user, $mysql_pass) || !mysql_select_db($mysql_db)) {
	die($conn_error);
} else { //echo '<div id= "style"> Connected to database. </div>';
}
/*
<style>
	#style{
		color:green;
		font-size: 50;
	}
	
</style>
*/


?>

