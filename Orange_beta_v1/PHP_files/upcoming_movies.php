<?php
require 'connect.to.movies.db.php';

$query = "SELECT * FROM april ";
//ORDER BY id DESC LIMIT 1

$x = mysql_query($query);	//sets the query in a array called x

//just so i can print the value rather then the array->17
 /*
$y =  mysql_fetch_row($x); 
$string = implode('|',$y);
echo $string;
*/
//same another way to just print the value 

//echo mysql_result($x,null);

/*  
while ($row = mysql_fetch_assoc($x)){
	print_r($row);	
	}
Output = Array ( [title] => Ebn-E-Batuta ) Array ( [title] => Honor Killing ) 
 * Array ( [title] => Jal ) Array ( [title] => Main Tera Hero )
 */ 
 

 
 //$column = array();
	while ($row = mysql_fetch_object($x)) {
		//array_push($column, $row);
		$column[] = $row;
	} 
	
	//print_r($column);
		//echo "</br>";
		//print_r($column->{'title'});
		//echo "</br>";
			
	print_r('{"april":'.json_encode($column).'}');
	//echo "</br>";
	//var_dump(json_encode($column));
	//print_r(json_encode($column[0]));
	

?>
