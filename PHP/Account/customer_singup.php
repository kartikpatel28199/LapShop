<?php
	
	include('../db_helper.php');
	$first=$_POST['firstname'];
	$last=$_POST['lastname'];
	$gender=$_POST['gender'];
	$email=$_POST['email'];
	$pass=$_POST['password'];
	$mobileno=$_POST['mobileno'];
	$datetime=$_POST['date'];

	$sql = "INSERT INTO `customer_singup` ( `firstname`, `lastname`,`gender`, `email`, `password`, `mobileno`,`datetime`) VALUES('$first','$last','$gender','$email','$pass','$mobileno','$datetime')";
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
?>