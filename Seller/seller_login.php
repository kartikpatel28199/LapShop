<?php
	session_start();
	
	$cn=mysqli_connect("localhost","root","","laptop");
	if($_POST['email']!="" && $_POST['password']!=""){
	$email=$_POST["email"];
	$pass=$_POST["password"];
	$sql = "SELECT * FROM `seller_signup` WHERE `email`='$email'AND `password`='$pass'";
	mysqli_query($cn,$sql);
	if(mysqli_affected_rows($cn)>0){
	    echo "1"; 
		$_SESSION["email"]=$email;
		//echo $_SESSION["email"];
		header("Location: http://localhost/seller/seller_home/seller_home.php?t1=$email");
	}
	else{
	    echo "-1";
	}
	}else{
	    echo "please insert email and password";
	}
	mysqli_close($cn);
	?>