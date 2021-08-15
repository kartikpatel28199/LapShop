<?php 
include('../db_helper.php'); 
$cemail=$_POST['cemail'];
$customer_city=$_POST['customer_city'];
$customer_locality=$_POST['customer_locality'];
$customer_flatno=$_POST['customer_flatno'];
$customer_pincode=$_POST['customer_pincode'];
$customer_state=$_POST['customer_state'];
$customer_landmark=$_POST['customer_landmark'];
$customer_name=$_POST['customer_name'];
$customer_mobileno=$_POST['customer_mobileno'];
$customer_alternativemobileno=$_POST['customer_alternativemobileno'];
$customer_addresstype=$_POST['customer_addresstype'];
$qry="INSERT INTO `manage_address` (`maid`, `cemail`, `customer_city`, `customer_locality`, `customer_flatno`, `customer_pincode`, `customer_state`, `customer_landmark`, `customer_name`, `customer_mobileno`, `customer_alternativemobileno`, `customer_addresstype`) VALUES (NULL, '$cemail', '$customer_city', '$customer_locality', '$customer_flatno', '$customer_pincode', '$customer_state', '$customer_landmark', '$customer_name', '$customer_mobileno', '$customer_alternativemobileno', '$customer_addresstype');";
mysqli_query($cn,$qry);
if(mysqli_affected_rows($cn)>0){
    echo "1";   
}
else{
    echo "-1";
}
mysqli_close($cn);
?>