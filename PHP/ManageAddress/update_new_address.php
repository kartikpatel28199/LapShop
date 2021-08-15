<?php 
include('../db_helper.php'); 
 $maid1=$_GET['maid'];
$cemail=$_POST['cemail'];
$customer_city=$_POST['customer_city'];
$customer_locality=$_POST['customer_locality'];
$customer_flatno=$_POST['customer_flatno'];
$customer_pincode=$_POST['customer_pincode'];
$customer_state=$_POST['customer_state'];
$customer_landmark=$_POST['customer_landmark'];
$customer_name=$_POST['customer_name'];
$customer_mobileno=$_POST['customer_mobileno'];
$customer_alternativemobileno=$_POST['customer_alternativemobileno'];
$customer_addresstype=$_POST['customer_addresstype'];

$qry="UPDATE  `lapshopi_lapshop`.`manage_address` SET  `cemail` =  '$cemail',
`customer_city` =  '$customer_city',
`customer_locality` =  '$customer_locality',
`customer_flatno` =  '$customer_flatno',
`customer_pincode` =  '$customer_pincode',
`customer_state` =  '$customer_state',
`customer_landmark` =  '$customer_landmark',
`customer_name` =  '$customer_name',
`customer_mobileno` =  '$customer_mobileno',
`customer_alternativemobileno` =  '$customer_alternativemobileno',
`customer_addresstype`='$customer_addresstype' WHERE  `manage_address`.`maid` ='$maid1';";
mysqli_query($cn,$qry);
if(mysqli_affected_rows($cn)>0){
    echo "1";   
}
else{
    echo "-1";
}
mysqli_close($cn);
?>