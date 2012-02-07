<?php
/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */

    //Format of encoded information:

    $size          = $_GET["size"];
    $option1       = "1".$_GET["poll_id"]/**.$_GET["option1"]*/;
    $option2       = "2".$_GET["poll_id"]/**.$_GET["option2"]*/;
    $option3       = "3".$_GET["poll_id"]/**.$_GET["option3"]*/;
    $option4       = "4".$_GET["poll_id"]/**.$_GET["option4"]*/;
    $option5       = "5".$_GET["poll_id"]/**.$_GET["option5"]*/;

/**
    $size          = "300x300";
    $option1       = "我爱maya";
    $option2       = "maya爱我";
    $option3       = "黑猫警长";
    $option4       = "=w=";
    $option5       = "快起床啦";
*/    
    $image1 = "https://chart.googleapis.com/chart?cht=qr&chs=$size&chl=$option1&choe=UTF-8&chld=H";
    $image2 = "https://chart.googleapis.com/chart?cht=qr&chs=$size&chl=$option2&choe=UTF-8&chld=H";
    $image3 = "https://chart.googleapis.com/chart?cht=qr&chs=$size&chl=$option3&choe=UTF-8&chld=H";;
    $image4 = "https://chart.googleapis.com/chart?cht=qr&chs=$size&chl=$option4&choe=UTF-8&chld=H";;
    $image5 = "https://chart.googleapis.com/chart?cht=qr&chs=$size&chl=$option5&choe=UTF-8&chld=H";;
 
    
	echo 'QRCode for Option 1 '.$_GET["option1"];
	echo '<img src="'.$image1.'">';
	echo 'QRCode for Option 2 '.$_GET["option2"];
	echo '<img src="'.$image2.'">';
	echo 'QRCode for Option 3 '.$_GET["option3"];
	echo '<img src="'.$image3.'">';
	echo 'QRCode for Option 4 '.$_GET["option4"];
	echo '<img src="'.$image4.'">';
	echo 'QRCode for Option 5 '.$_GET["option5"];
	echo '<img src="'.$image5.'">';

?>
