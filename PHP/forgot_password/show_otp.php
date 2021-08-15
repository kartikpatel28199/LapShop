<?php

include('../db_helper.php');  	
 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: " . mysqli_connect_error();
 die();
 }
 
 $e=$_GET['e'];
 $ssql="SELECT * FROM `customer_singup` WHERE `email`='$e'";
 $result=mysqli_query($cn,$ssql);
 $mobileno=0;
 while($row=mysqli_fetch_array($result)){
 $mobileno=$row['mobileno'];
 }

 $query = "SELECT MAX( fid ) , mobileno, otp FROM `forgot_password` WHERE `mobileno`='$mobileno' AND `fid` IN (SELECT MAX( fid )FROM `forgot_password`)GROUP BY mobileno, otp LIMIT 0 , 30";  
      $result = mysqli_query($cn, $query);  
            	  $row = $result->fetch_all(MYSQLI_ASSOC);
  
      echo json_encode($row);
?>