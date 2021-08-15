<?php 
include('../db_helper.php');
$oid=$_GET['oid'];
$qry="DELETE FROM `lapshopi_lapshop` WHERE `oid`='$oid'";
mysqli_query($cn,$qry);
if(mysqli_affected_rows($cn)>0){
    echo "1";   
}
else{
    echo "-1";
}
mysqli_close($cn);
?>