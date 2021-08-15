<?php 
include('db_helper.php');
  	
 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: " . mysqli_connect_error();
 die();
 }
 
 
$idd=$_GET['id'];
  $query = "SELECT * FROM `lapshop_specification`WHERE `sid`='$idd'";  
      $result = mysqli_query($cn, $query);  
      	  $row = $result->fetch_all(MYSQLI_ASSOC);
echo json_encode($row);
?>