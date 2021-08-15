<?php
	$cn=mysqli_connect("localhost","lapshopi_nikkat","nikkat@1234","lapshopi_lapshop");
	if($_POST['email']!="" && $_POST['password']!=""){
	$email=$_POST["email"];
	$pass=$_POST["password"];
	$sql = "SELECT * FROM `seller_singup` WHERE `email`='$email'AND `password`='$pass'";
	mysqli_query($cn,$sql);
	if(mysqli_affected_rows($cn)>0){
	    echo "1";   
	}
	else{
	    echo "-1";
	}
	}else{
	    echo "please insert email and password";
	}
	mysqli_close($cn);
	?>