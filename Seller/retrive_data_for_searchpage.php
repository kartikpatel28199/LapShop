<?php 
$cn =mysqli_connect("localhost","lapshopi_nikkat","nikkat@1234","lapshopi_lapshop");
  	
 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: " . mysqli_connect_error();
 die();
 }
 
 
$idd=$_GET['email'];
 $stmt = $cn->prepare("SELECT * FROM `lapshop_specification`WHERE `seller_email`='$idd';");
 
 $stmt->execute();
 
 $stmt->bind_result($sid,$seller_username,$datetime, $laptop_type, $laptop_title, $laptop_brand,$laptop_modelname, $laptop_modelno,$laptop_shortdesc, $laptop_price, $laptop_color, $battary_backup, $processor_brand, $processor_name, $processor_generation, $ssd, $ram, $ram_type, $hdd_capacity, $processor_variant, $clock_speed, $cache, $graphics_processor, $operating_system, $mic_in, $touch_screen, $screen_size, $screen_resolution, $screen_type, $speakers, $internal_mic, $sound_properties, $wireless_lan, $bluetooth, $ethernet, $disk_drive, $web_camera, $read_write_speed, $keybord, $pointer_device, $battery, $battery_type, $warranty_summary, $warranty_service_type, $covered_in_warranty, $not_covered_in_warranty, $domestic_warranty, $image_1, $image_2,$image_3,$image_4,$image_5);
 $laptop = array(); 
 
 while($stmt->fetch()){
 $temp = array();
 $temp['sid'] = $sid; 
 $temp['seller_username']=$seller_username;
 $temp['laptop_type']=$laptop_type;
 $temp['laptop_title']=$laptop_title;
 $temp['laptop_brand']=$laptop_brand;
 
 $temp['laptop_modelname']=$laptop_modelname;
 $temp['laptop_modelno']=$laptop_modelno;
 $temp['laptop_shortdesc']=$laptop_shortdesc;
 $temp['laptop_price']=$laptop_price;
 $temp['laptop_color']=$laptop_color;
 $temp['battary_backup']=$battary_backup;
 $temp['processor_brand']=$processor_brand;
 $temp['processor_name']=$processor_name;
 $temp['processor_generation']=$processor_generation;
 $temp['ssd']=$ssd;
 $temp['ram']=$ram;
 $temp['ram_type']=$ram_type;
 $temp['hdd_capacity']=$hdd_capacity;
 $temp['processor_variant']=$processor_variant;
 $temp['clock_speed']=$clock_speed;
 $temp['cache']=$cache;
 $temp['graphics_processor']=$graphics_processor;
 $temp['operating_system']=$operating_system;
 $temp['mic_in']=$mic_in;
 $temp['touch_screen']=$touch_screen;
 $temp['screen_size']=$screen_size;
 $temp['screen_resolution']=$screen_resolution;
 $temp['screen_type']=$screen_type;
 $temp['speakers']=$speakers;
 $temp['internal_mic']=$internal_mic;
 $temp['sound_properties']=$sound_properties;
 $temp['wireless_lan']=$wireless_lan;
 $temp['bluetooth']=$bluetooth;
 $temp['ethernet']=$ethernet;
 $temp['disk_drive']=$disk_drive;
 $temp['web_camera']=$web_camera;
 $temp['read_write_speed']=$read_write_speed;
 $temp['keybord']=$keybord;
 $temp['pointer_device']=$pointer_device;
 $temp['pointer_device']=$pointer_device;
 $temp['battery']=$battery;
 $temp['battery_type']=$battery_type;
 $temp['warranty_summary']=$warranty_summary;
 $temp['warranty_service_type']=$warranty_service_type;
 $temp['covered_in_warranty']=$covered_in_warranty;
 $temp['not_covered_in_warranty']=$not_covered_in_warranty;
 $temp['domestic_warranty']=$domestic_warranty;
 $temp["image_1"]=$image_1;
 $temp["image_2"]=$image_2;
 $temp["image_3"]=$image_3;
 $temp["image_4"]=$image_4;
 $temp["image_5"]=$image_5;
 array_push($laptop, $temp);
 }
 echo json_encode($laptop);
 ?>