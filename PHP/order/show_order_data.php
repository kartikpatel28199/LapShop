<?php 
include('../db_helper.php');
 
 $c_email1=$_GET['c_email'];	
$query = "SELECT * FROM `order_now` WHERE `c_email`='$e_email1';";  
      $result = mysqli_query($cn, $query);  
            	  $row = $result->fetch_all(MYSQLI_ASSOC);
  
      echo json_encode($row);
?>