<?php 
include('../db_helper.php');
 $maid1=$_GET['maid'];
$query = "SELECT * FROM `manage_address` WHERE `maid`='$maid1';";  
      $result = mysqli_query($cn, $query);  
      	  $row = $result->fetch_all(MYSQLI_ASSOC);
      echo json_encode($row);
?>