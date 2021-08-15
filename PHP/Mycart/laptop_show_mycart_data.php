<?php 
include('../db_helper.php');
 
 $email1=$_GET['email'];
 $query = "SELECT * FROM `laptop_mycart` WHERE email='$email1';";  
      $result = mysqli_query($cn, $query);  
            	  $row = $result->fetch_all(MYSQLI_ASSOC);
  
      echo json_encode($row);
?>