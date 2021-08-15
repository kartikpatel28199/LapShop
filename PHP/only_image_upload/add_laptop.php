<?php

include('../db_helper.php');	
	if($conn)
	{
		echo "established";
	}
	else{
		echo " not established";
	}
	$file_tmp = $_FILES['image']['tmp_name'];
	$num = array();
	
	for($i=0; $i<=count($file_tmp); $i++)
	{
		if(!empty($file_tmp[$i]))
		{
			$num[$i] = addslashes(file_get_contents($file_tmp[$i]));
		}
	}
	

	$short_desc=$_POST['short_desc'];
	$price=$_POST['price'];
	$brand=$_POST['brand'];
	$model_number=$_POST['model_number'];
	$series=$_POST['series'];
	$color=$_POST['color'];
	$type=$_POST['type'];
	$battery_backup=$_POST['battery_backup'];
	$processor_brand=$_POST['processor_brand'];
	$processor_name=$_POST['processor_name'];
	$processor_generation=$_POST['processor_generation'];
	$ssd=$_POST['ssd'];
	$ram=$_POST['ram'];
	$ram_type=$_POST['ram_type'];
	$hdd_capacity=$_POST['hdd_capacity'];
	$clock_speed=$_POST['clock_speed'];
	$cache=$_POST['cache'];
	$graphics_processor=$_POST['graphics_processor'];
	$os=$_POST['os'];
	$mic_in=$_POST['mic_in'];
	$touch_screen=$_POST['touch_screen'];
	$screen_size=$_POST['screen_size'];
	$screen_resolution=$_POST['screen_resolution'];
	$screen_type=$_POST['screen_type'];
	$speakers=$_POST['speakers'];
	$internal_mic=$_POST['internal_mic'];
	$sound_properties=$_POST['sound_properties'];
	$wireless_lan=$_POST['wireless_lan'];
	$bluetooth=$_POST['bluetooth'];
	$ethernet=$_POST['ethernet'];
	$weight=$_POST['weight'];
	$disk_drive=$_POST['disk_drive'];
	$web_camera=$_POST['web_camera'];
	$read_write_speed=$_POST['read_write_speed'];
	$keyboard=$_POST['keyboard'];
	$warranty_summary=$_POST['warranty_summary'];
	$covered_in_warranty=$_POST['covered_in_warranty'];
	$not_covered_in_warranty=$_POST['not_covered_in_warranty'];
	$domestic_warranty=$_POST['domestic_warranty'];
	
	$qry="INSERT INTO `lapshop_specification` (image_1`, `image_3`, `image_4`, `image_5`) VALUES('$num[0]','$num[1]','$num[2]','$num[3]','$num[4]' )";
	
	
    if(mysqli_query($conn,$qry))
	{
		echo "success";
	}
	else
	{
		echo "unsuccess";
	}
	
?>