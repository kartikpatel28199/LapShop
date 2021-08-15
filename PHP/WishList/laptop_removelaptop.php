<?php 
include('../db_helper.php');
$id=$_GET['id'];
$qry="DELETE FROM `laptop_wishlist` WHERE `id`='$id'";
mysqli_query($cn,$qry);
if(mysqli_affected_rows($cn)>0){
    echo "1";   
}
else{
    echo "-1";
}
mysqli_close($cn);
?>