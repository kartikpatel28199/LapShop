	
<?php 
 $upload_path = 'laptop_image/';
 $upload_url = 'http://nikunjramani.000webhostapp.com/Lapshop/'.$upload_path; 
 $response = array(); 
 
 if($_SERVER['REQUEST_METHOD']=='POST'){ 
		$con =mysqli_connect("localhost","id4111561_nikkat","nikkat","id4111561_nikkat") or die('Unable to Connect...');
		$title = $_POST['laptop_title'];
		$brand = $_POST['laptop_brand'];
		$shortdesc = $_POST['laptop_shortdesc'];
		$price = $_POST['laptop_price'];
		$fileinfo = pathinfo($_FILES['image_1']['name']); 
		$extension = $fileinfo['extension'];
		$file_url = $upload_url . getFileName() . '.' . $extension;
		$file_path = $upload_path . getFileName() . '.'. $extension; 

		try{
			move_uploaded_file($_FILES['image_1']['tmp_name'],$file_path);
			$sql = "INSERT INTO `lapshop_specification` (`laptop_title`, `laptop_brand`, `laptop_shortdesc`, `laptop_price`, `image_1`) VALUES('$title','$brand','$shortdesc','$price','$file_url')";
			mysqli_query($con,$sql);
		}catch(Exception $e){
			$response['error']=true;
			$response['message']=$e->getMessage();
		}	 
		echo json_encode($response);
			mysqli_close($con);
 }
 
 function getFileName(){
$con =mysqli_connect("localhost","id4111561_nikkat","nikkat","id4111561_nikkat") or die('Unable to Connect...');
 $sql = "SELECT max(id) as id FROM `laptop_specification`";
 $result = mysqli_fetch_array(mysqli_query($con,$sql));

 if($result['id']==null)
 return 1; 
 else 
 return ++$result['id']; 
 mysqli_close($con);
 }
 ?>