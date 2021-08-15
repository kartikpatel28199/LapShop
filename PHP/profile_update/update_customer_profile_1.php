<?php 
include('../db_helper.php'); 
 $e=$_GET['e'];
$email=$_POST['email'];
$firstname=$_POST['firstname'];
$lastname=$_POST['lastname'];
$mobileno=$_POST['mobileno'];
$qry="UPDATE `customer_singup` SET `firstname` = '$firstname', `lastname` = '$lastname', `email` = '$email', `mobileno` = '$mobileno' WHERE `customer_singup`.`email` = '$e'";
mysqli_query($cn,$qry);
if(mysqli_affected_rows($cn)){
    echo "1";   
}
else{
    echo "-1";
}
mysqli_close($cn);
?>