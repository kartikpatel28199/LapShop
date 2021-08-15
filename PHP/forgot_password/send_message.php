<?php

include('../db_helper.php');  	
 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: " . mysqli_connect_error();
 die();
 }
 
 $e=$_GET['e'];
 $ssql="SELECT * FROM `customer_singup` WHERE `email`='$e'";
 $result=mysqli_query($cn,$ssql);
 $mobileno=0;
 while($row=mysqli_fetch_array($result)){
 $mobileno=$row['mobileno'];
 }
 echo  $mobileno;

$otp = rand(100000, 999999);
$msg="Welcome to Lapshop Shopping App: Your verification code is $otp";
echo $msg;
$sql="INSERT INTO  `lapshopi_lapshop`.`forgot_password` (
`fid` ,
`mobileno` ,
`otp`
)
VALUES (
NULL ,  '$mobileno',  '$otp'
);";
mysqli_query($cn,$sql);
send("7624069124","69124",$mobileno,$msg);

function send($username,$password,$mobile_number,$text)

	{

		//start

			

			

		//Prepare you post parameters

				$postData = array(

					'uname' => $username,

					'pass' => $password,

					'mobile' => $mobile_number,

					'text' => $text

				);

				

				//API URL

				$url="http://www.incisivewebsolution.com/sms/send2017_7.php";

				

				// init the resource

				$ch = curl_init();

				curl_setopt_array($ch, array(

					CURLOPT_URL => $url,

					CURLOPT_RETURNTRANSFER => true,

					CURLOPT_POST => true,

					CURLOPT_POSTFIELDS => $postData,

					//,CURLOPT_FOLLOWLOCATION => true

				));

				

				//get response

				$output = curl_exec($ch);

				

				curl_close($ch);

				//echo $output;

				//end

	}

?>

