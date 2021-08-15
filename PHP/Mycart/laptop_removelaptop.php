<?php 
include('../db_helper.php');
$sid=$_GET['sid'];
$qry="DELETE FROM `laptop_mycart` WHERE `sid`='$sid'";
mysqli_query($cn,$qry);
if(mysqli_affected_rows($cn)>0){
    echo "1";   
}
else{
    echo "-1";
}
mysqli_close($cn);
?>