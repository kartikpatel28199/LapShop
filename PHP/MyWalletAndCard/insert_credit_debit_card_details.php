<?php 
include('../db_helper.php');
$cemail=$_POST['cemail'];
$card_number=$_POST['card_number'];
$expiry_date=$_POST['expiry_date'];
$card_name=$_POST['card_name'];
$card_label=$_POST['card_label'];
$qry="INSERT INTO `credit_debit_card` (`cdid`, `cemail`, `card_number`, `expiry_date`, `card_name`, `card_label`) VALUES (NULL, '$cemail', '$card_number', '$expiry_date', '$card_number', '$card_label');";
mysqli_query($cn,$qry);
if(mysqli_affected_rows($cn)>0){
    echo "1";   
}
else{
    echo "-1";
}
mysqli_close($cn);
?>