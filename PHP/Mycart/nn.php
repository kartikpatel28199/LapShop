<?php 
include('../db_helper.php'); 
 $email1=$_GET['email'];
 $stmt = $cn->prepare("SELECT * FROM `laptop_mycart`WHERE email='$email1';");
 
 $stmt->execute();
 
 $stmt->bind_result($id, $sid, $email, $title,$brand, $screensize, $price,$image_1);
 
 $laptop = array(); 
 
 while($stmt->fetch()){
 $temp = array();
 $temp['id'] = $id;
 $temp['sid']=$sid;
 $temp['email']=$email;
 $temp['laptop_title'] = $title; 
 $temp['laptop_brand'] = $brand; 
 $temp['screen_size'] = $screensize;
 $temp['laptop_price'] = $price; 
 $temp['image_1']=$image_1;
 array_push($laptop, $temp);
 }
 
 echo json_encode($laptop);
 ?>