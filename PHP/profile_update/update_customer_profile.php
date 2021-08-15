<?php 
include('../db_helper.php'); 
 $email=$_GET['email'];
 $stmt = $cn->prepare("SELECT * FROM `customer_singup`WHERE `email`='$email';");
 
 $stmt->execute();
 
 $stmt->bind_result($cid,$firstname, $lastname,$gender,$email, $password, $mobileno,$datetime);
 
 $laptop = array(); 
 
 while($stmt->fetch()){
 $temp = array();
 $temp['cid'] = $cid; 
 $temp['firstname']=$firstname;
 $temp['lastname'] = $lastname; 
 $temp['gender']=$gender;
 $temp['email'] = $email; 
 $temp['password'] = $password;
 $temp['mobileno'] = $mobileno; 
 $temp['datetime']=$datetime;
 array_push($laptop, $temp);
 }
 
 echo json_encode($laptop);
 ?>