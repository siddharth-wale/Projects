<?php

	function get_price($find){
		$books = array(
            "Abarelix" => 2,
            "Abilify" => 12,
			"Cafcit" => 21,
			"Cefizox" => 4,
			"Combiflam" => 9,
			"Aspirin" => 8,
			"Paracetamol" => 10,
			"Naftifine" => 5,
			"Rabavert" => 7,
			"Wellbutrin" => 2,
			"Valcyte" => 3,
			"Raloxifene" => 7,
			"Ogen" => 2,
			"Olux" => 2,
			"Onsolis" => 7,
			"Haloperidol" => 3,
			"Halcinonide" => 9
		);
		foreach($books as $book => $price){
			if($book == $find){
				return $price;
				break;
			}
		}
        
	}
?>