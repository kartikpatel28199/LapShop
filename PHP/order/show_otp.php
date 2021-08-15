<?php

include('../db_helper.php');
  	
 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: " . mysqli_connect_error();
 die();
 }
 
 $e=$_GET['e'];
$query = "SELECT * FROM `customer_singup` WHERE `email`='$e'";  
      $result = mysqli_query($cn, $query);  
            	  $row = $result->fetch_all(MYSQLI_ASSOC);
  
      echo json_encode($row);
	  
$stmt=$cn->prepare("SELECT MAX( onoid ) , mobileno, otp, TIME FROM order_now_otp WHERE mobileno='$mobileno' AND onoid IN (SELECT MAX( onoid )FROM order_now_otp)GROUP BY mobileno, otp, TIME LIMIT 0 , 30");
$stmt->execute();
$stmt->bind_result($fid,$mobileno1,$otp,$time);
$lapshop=array();
while($stmt->fetch()){
$temp=array();
$temp['fid']=$fid;
$temp['mobileno']=$mobileno1;
$temp['otp']=$otp;
array_push($lapshop,$temp);
}
echo json_encode($lapshop);
?>