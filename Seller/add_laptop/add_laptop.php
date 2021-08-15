<?php
$conn=mysqli_connect("localhost","lapshopi_nikkat","nikkat@1234","lapshopi_lapshop");
	$upload_path = 'image/';
	 $upload_url = 'http://lapshop.in.net/seller/add_laptop/'.$upload_path;
 $response = array();
	if($conn)
	{
		echo "established";
	}
	else{
		echo " not established";
	}	
    $type=$_POST['type'];
	$title=$_POST['laptop_title'];
	$brand=$_POST['brand'];
	$model_name=$_POST['model_name'];
	$model_number=$_POST['model_number'];
	$short_desc=$_POST['short_desc'];
	$price=$_POST['price'];
	$color=$_POST['color'];
	$battery_backup=$_POST['battery_backup'];
	$processor_brand=$_POST['processor_brand'];
	$processor_name=$_POST['processor_name'];
	$processor_generation=$_POST['processor_generation'];
	$ssd=$_POST['ssd'];
	$ram=$_POST['ram'];
	$ram_type=$_POST['ram_type'];
	$hdd_capacity=$_POST['hdd_capacity'];
	$processor_variant=$_POST['processor_variant'];
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
	$disk_drive=$_POST['disk_drive'];
	$web_camera=$_POST['web_camera'];
	$read_write_speed=$_POST['read_write_speed'];
	$keybord=$_POST['keybord'];
	$pointer=$_POST['pointer_device'];
	$battery=$_POST['battery'];
	$battery_type=$_POST['battery_type'];
	$warranty_summary=$_POST['warranty_summary'];
	$warranty_service_type=$_POST['warranty_service_type'];
	$covered_in_warranty=$_POST['covered_in_warranty'];
	$not_covered_in_warranty=$_POST['not_covered_in_warranty'];
	$domestic_warranty=$_POST['domestic_warranty'];
	
	$fileinfo1 = pathinfo($_FILES['image_1']['name']); 
	$name1 = $_FILES['image_1']['name'];
	$extension1 = $fileinfo1['extension'];
	$file_url1 = $upload_url . getFileName1().'.'.$extension1;
	$file_path1 = $upload_path . getFileName1().'.'.$extension1;
	
	$fileinfo2 = pathinfo($_FILES['image_2']['name']); 
	$name2 = $_FILES['image_2']['name'];
	$extension2 = $fileinfo2['extension'];
	$file_url2 = $upload_url . getFileName2().'.'.$extension2;
	$file_path2 = $upload_path . getFileName2().'.'.$extension2;
	
	$fileinfo3 = pathinfo($_FILES['image_3']['name']); 
	$name3 = $_FILES['image_3']['name'];
	$extension3 = $fileinfo3['extension'];
	$file_url3 = $upload_url . getFileName3().'.'.$extension3;
	$file_path3 = $upload_path . getFileName3().'.'.$extension3;
	
	$fileinfo4 = pathinfo($_FILES['image_4']['name']); 
	$name4 = $_FILES['image_4']['name'];
	$extension4 = $fileinfo4['extension'];
	$file_url4 = $upload_url . getFileName4().'.'.$extension4;
	$file_path4 = $upload_path . getFileName4().'.'.$extension4;
	
	$fileinfo5 = pathinfo($_FILES['image_5']['name']); 
	$name5 = $_FILES['image_5']['name'];
	$extension5 = $fileinfo5['extension'];
	$file_url5 = $upload_url . getFileName5().'.'.$extension5;
	$file_path5 = $upload_path . getFileName5().'.'.$extension5;

	try{
	move_uploaded_file($_FILES['image_1']['tmp_name'],$file_path1);
	move_uploaded_file($_FILES['image_2']['tmp_name'],$file_path2);
	move_uploaded_file($_FILES['image_3']['tmp_name'],$file_path3);
	move_uploaded_file($_FILES['image_4']['tmp_name'],$file_path4);
	move_uploaded_file($_FILES['image_5']['tmp_name'],$file_path5);
	$qry="INSERT INTO `lapshopi_lapshop`.`lapshop_specification` (`sid`, `seller_email`, `datetime`, `laptop_type`, `laptop_title`, `laptop_brand`, `laptop_modelname`, `laptop_modelno`, `laptop_shortdesc`, `laptop_price`, `laptop_color`, `battary_backup`, `processor_brand`, `processor_name`, `processor_generation`, `ssd`, `ram`, `ram_type`, `hdd_capacity`, `processor_variant`, `clock_speed`, `cache`, `graphics_processor`, `operating_system`, `mic_in`, `touch_screen`, `screen_size`, `screen_resolution`, `screen_type`, `speakers`, `internal_mic`, `sound_properties`, `wireless_lan`, `bluetooth`, `ethernet`, `disk_drive`, `web_camera`, `read_write_speed`, `keybord`, `pointer_device`, `battery`, `battery_type`, `warranty_summary`, `warranty_service_type`, `covered_in_warranty`, `not_covered_in_warranty`, `domestic_warranty`, `image_1`, `image_2`, `image_3`, `image_4`, `image_5`) VALUES  (NULL,'',now(),'$type', '$title', '$brand', '$model_name', '$model_number', '$short_desc', '$price', '$color', '$battery_backup', '$processor_brand', '$processor_name', '$processor_generation', '$ssd', '$ram', '$ram_type', '$hdd_capacity', '$processor_variant', '$clock_speed', '$cache', '$graphics_processor', '$os', '$mic_in', '$touch_screen', '$screen_size', '$screen_resolution', '$screen_type', '$speakers', '$internal_mic', '$sound_properties', '$wireless_lan', '$bluetooth', '$ethernet', '$disk_drive', '$web_camera', '$read_write_speed', '$keybord', '$pointer', '$battery', '$battery_type', '$warranty_summary', '$warranty_service_type', '$covered_in_warranty', '$not_covered_in_warranty', '$domestic_warranty', '$file_url1', '$file_url2', '$file_url3', '$file_url4', '$file_url5')";
    mysqli_query($conn,$qry);
	echo mysqli_affected_rows($conn);
			}catch(Exception $e){
			$response['error']=true;
			$response['message']=$e->getMessage();
		}	 
//		echo json_encode($response);
	
function getFileName1(){
 $con = mysqli_connect("localhost","lapshopi_nikkat","nikkat@1234","lapshopi_lapshop") or die('Unable to Connect...');
 $sql = "SELECT max(sid) as sid FROM `lapshop_specification`";
 $result = mysqli_fetch_array(mysqli_query($con,$sql));
 
 mysqli_close($con);
 if($result['sid']==null)
 return 1; 
 else 
return ++$result['sid'].'_1';
 }
 function getFileName2(){
 $con = mysqli_connect("localhost","lapshopi_nikkat","nikkat@1234","lapshopi_lapshop") or die('Unable to Connect...');
 $sql = "SELECT max(sid) as sid FROM `lapshop_specification`";
 $result = mysqli_fetch_array(mysqli_query($con,$sql));
 
 mysqli_close($con);
 if($result['sid']==null)
 return 1; 
 else 
return ++$result['sid'].'_2';
 }
 function getFileName3(){
 $con = mysqli_connect("localhost","lapshopi_nikkat","nikkat@1234","lapshopi_lapshop") or die('Unable to Connect...');
 $sql = "SELECT max(sid) as sid FROM `lapshop_specification`";
 $result = mysqli_fetch_array(mysqli_query($con,$sql));
 
 mysqli_close($con);
 if($result['sid']==null)
 return 1; 
 else 
return ++$result['sid'].'_3';
 }
 function getFileName4(){
 $con = mysqli_connect("localhost","lapshopi_nikkat","nikkat@1234","lapshopi_lapshop") or die('Unable to Connect...');
 $sql = "SELECT max(sid) as sid FROM `lapshop_specification`";
 $result = mysqli_fetch_array(mysqli_query($con,$sql));
 
 mysqli_close($con);
 if($result['sid']==null)
 return 1; 
 else 
return ++$result['sid'].'_4';
 }
 function getFileName5(){
 $con = mysqli_connect("localhost","lapshopi_nikkat","nikkat@1234","lapshopi_lapshop") or die('Unable to Connect...');
 $sql = "SELECT max(sid) as sid FROM `lapshop_specification`";
 $result = mysqli_fetch_array(mysqli_query($con,$sql));
 
 mysqli_close($con);
 if($result['sid']==null)
 return 1; 
 else 
return ++$result['sid'].'_5';
 }
?>