<?php 
include('../db_helper.php'); 
 $maid1=$_GET['maid'];
$qry="DELETE FROM `manage_address` WHERE `maid`='$maid1'";
mysqli_query($cn,$qry);
if(mysqli_affected_rows($cn)>0){
    echo "1";   
}
else{
    echo "-1";
}
mysqli_close($cn);
?>