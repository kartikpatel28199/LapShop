<?php
include('../db_helper.php');  	
 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: " . mysqli_connect_error();
 die();
 }
 $mobileno=$_POST['mobileno'];
 $password=$_POST['password'];
 $sql="UPDATE `customer_singup` SET `password`='$password' WHERE `mobileno`='$mobileno'";
 mysqli_query($cn,$sql);
 if(mysqli_affected_rows($cn)>0){
	    echo "1";   
	}
	else{
	    echo "-1";
	}
mysqli_close($cn);
?>