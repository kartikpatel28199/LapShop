<?php 
include('../db_helper.php');
  $cemail=$_GET["cemail"];
 $query = "SELECT * FROM `giftcard` WHERE `cemail`='$cemail';";  
      $result = mysqli_query($cn, $query);  
            	  $row = $result->fetch_all(MYSQLI_ASSOC);
  
      echo json_encode($row);
?>