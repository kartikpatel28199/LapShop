<?php 
include('../db_helper.php');
$email=$_GET['email'];
$sql = "SELECT * FROM `customer_singup` WHERE `email`='$email'";

$r = mysqli_query($cn,$sql);

$result = array();

while($row = mysqli_fetch_row($r)){
    array_push($result,array(
        'cid'=>$row['cid']
    ));
}

echo json_encode(array('result'=>$result));

mysqli_close($con);