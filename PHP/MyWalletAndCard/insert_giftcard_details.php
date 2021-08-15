<?php 
include('../db_helper.php'); 
$cemail=$_POST['cemail'];
$gift_card_number=$_POST['gift_card_number'];
$gift_card_pincode=$_POST['gift_card_pincode'];

$qry="INSERT INTO `giftcard` (`gcid`, `cemail`, `gift_card_number`, `gift_card_pincode`) VALUES (NULL, '$cemail', '$gift_card_number', '$gift_card_pincode');";
mysqli_query($cn,$qry);
if(mysqli_affected_rows($cn)>0){
    echo "1";   
}
else{
    echo "-1";
}
mysqli_close($cn);
?>