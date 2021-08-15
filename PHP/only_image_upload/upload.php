<?php
include('../db_helper.php');
	$file_tmp = $_FILES['image']['tmp_name'];
	$num = array();
	
	for($i=0; $i<=count($file_tmp); $i++)
	{
		if(!empty($file_tmp[$i]))
		{
			$num[$i] = addslashes(file_get_contents($file_tmp[$i]));
		}
	}
	
	$query="INSERT INTO `lapshop_specification` (`image_1`,`image_2`,`image_3`,`image_4`,`image_5`) VALUES ('$num[0]','$num[1]','$num[2]','$num[3]','$num[4]')";
    if(mysqli_query($cn,$query))
	{
		echo "success";
	}
	else
	{
		echo "unsuccess";
	}
?>