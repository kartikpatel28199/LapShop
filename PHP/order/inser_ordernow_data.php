<?php 
include('../db_helper.php'); 
$sid=$_POST['sid'];
$price=$_POST['price'];
$c_email=$_POST['cemail'];
$cdid=$_POST['cdid'];
$maid=$_POST['maid'];
$payment=$_POST['payment_method'];

$s="SELECT * FROM `lapshop_specification` WHERE `sid`='$sid'";
$r=mysqli_query($cn,$s);
$title=null;
$image_1=null;
while($row=mysqli_fetch_array($r)){
$title=$row['laptop_title'];
$image_1=$row['image_1'];
}
$qry="INSERT INTO `lapshopi_lapshop`.`order_now` (`oid`, `c_email`, `sid`,`price`, `datetime`, `cdid`, `maid`,`tracking`,`payment_method`,`title`,`image_1`) VALUES (NULL, '$c_email', '$sid','$price', now(), '$cdid', '$maid','Book','$payment','$title','$image_1')";
mysqli_query($cn,$qry);
if(mysqli_affected_rows($cn)>0){
    echo "1";   
}
else{
    echo "-1";
}
mysqli_close($cn);
?>