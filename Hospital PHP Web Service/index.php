<?php

	header("Content-Type:application/json");
	include("functions.php");

	if(!empty($_GET['name'])){
		$name = $_GET['name'];
		$price = get_price($name);
		
		if(empty($price)){
            deliver_response(200,"Medicine not Found", NULL);
        }
		else{
            deliver_response(200,$name, $price);
        }
			
	}else{

		deliver_response(400,"Invalid Request", NULL);
	}
	
	
	function deliver_response($status, $medicine_name, $medicine_price){
		header("HTTP/1.1 $status $medicine_name");
		
		$response['status'] = $status;
		$response['medicine_name'] = $medicine_name;
		$response['medicine_price'] = $medicine_price;
		
		$json_response = json_encode($response);
		echo $json_response;
        
	}
?>