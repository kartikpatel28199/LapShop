<?php 
include('../db_helper.php'); 
$sid=$_POST['sid'];
$email=$_POST['email'];
$title=$_POST['laptop_title'];
$brand=$_POST['laptop_brand'];
$screensize=$_POST['screen_size'];
$color=$_POST['color'];
$price=$_POST['laptop_price'];
$image=$_POST['image_1'];
$qry="INSERT INTO `laptop_wishlist` (`id`, `sid`, `email`, `laptop_title`, `laptop_brand`, `screen_size`, `color`, `laptop_price`, `image_1`) VALUES(NULL,'$sid','$email','$title', '$brand', '$screensize','$color','$price','$image')";
mysqli_query($cn,$qry);
if(mysqli_affected_rows($cn)>0){
    echo "1";   
}
else{
    echo "-1";
}
mysqli_close($cn);
?>