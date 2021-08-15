<?php
	
	$cn=mysqli_connect("localhost","lapshopi_nikkat","nikkat@1234","lapshopi_lapshop");
	if($_POST['firstname']!="" && $_POST['lastname']!="" && $_POST['email']!="" && $_POST['password']!="" && $_POST['mobileno']!=""){
	$first=$_POST['firstname'];
	$last=$_POST['lastname'];
	$email=$_POST['email'];
	$pass=$_POST['password'];
	$mobileno=$_POST['mobileno'];

	$sql = "INSERT INTO `seller_singup` ( `firstname`, `lastname`, `email`, `password`, `mobileno`,`datetime`) VALUES('$first','$last','$email','$pass','$mobileno',now())";
	mysqli_query($cn,$sql);
	if(mysqli_affected_rows($cn)>0)
	{
	    echo "1";   
	}
	else
	{
	    echo "-1";
	}
	mysqli_close($cn);
	}else{
	echo "please enter valid data" ;
	}
?>