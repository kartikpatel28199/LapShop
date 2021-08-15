<?php
if(!empty($_GET['id'])){
    //DB details
include('../db_helper.php')
    $id = $_GET['id']; 
	$query = "SELECT * FROM `lapshop_specification` WHERE `id`='$id'"; 
	$result = mysqli_query($cn,$query) or die(mysqli_error()); 
	$photo = mysqli_fetch_array($result); 
	header('Content-Type:image/jpeg'); 
	echo $photo['image_1']; 
}
?>