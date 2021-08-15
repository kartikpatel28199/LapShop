<?php
	$cn=mysqli_connect("localhost","root","","laptop");
	if($_POST['firstname']!="" && $_POST['lastname']!="" && $_POST['email']!="" && $_POST['password']!="" ){
	$first=$_POST['firstname'];
	$last=$_POST['lastname'];
	$email=$_POST['email'];
	$pass=$_POST['password'];
		
	if($cn==null)
	{
		echo "success";
	}
	else{
		echo "uncess";
	}

	$sql = "INSERT INTO `laptop`.`seller_signup` (`id`, `firstname`, `lastname`, `email`, `password`) VALUES (NULL, '$first', '$last', '$email', '$pass')";
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
	}
	
	else{
	echo "please enter valid data" ;
	}
?>