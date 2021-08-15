<?php 
include('db_helper.php');
 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: " . mysqli_connect_error();
 die();
 }


 $query = "SELECT * FROM `lapshop_specification`";  
      $result = mysqli_query($cn, $query);  
     // $row = fetch_all($result);  
	  $row = $result->fetch_all(MYSQLI_ASSOC);
      echo json_encode($row);
?>