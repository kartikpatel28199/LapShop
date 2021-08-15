<?php

send("7624069124","69124"","mobile number","text");

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

				$url="http://www.incisivewebsolution.com/sms/send.php";

				

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

