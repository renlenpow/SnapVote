<?php 

//Insert into config.php
$topic = $_GET["topic"];
$nOption = $_GET["nOption"];
$option1 = $_GET["option1"];
$option2 = $_GET["option2"];
$option3 = $_GET["option3"];
$option4 = $_GET["option4"];
$option5 = $_GET["option5"];
$poll_id = $_GET["poll_id"]; 
$key = '$VALID_POLLS = array();'; 
$newline = '$p = new Poll;
$p->question = "'.$topic.'";	
$p->returnToURL = "../example.php";				
$p->legend = "This is a Poll";						
$p->control_type = $CONTROL_RADIOBUTTONS;		
$p->add_value("1", "'.$option1.'");	
$p->add_value("2", "'.$option2.'");
$p->add_value("3", "'.$option3.'");
$p->add_value("4", "'.$option4.'");
$p->add_value("5", "'.$option5.'");
$VALID_POLLS["'.$poll_id.'"] = $p;'; 

//copy file to prevent double entry 
$file = "config.php"; 
$newfile = "filetemp.txt"; 
copy($file, $newfile) or exit("failed to copy $file"); 

//load file into $lines array 
 $fc = fopen ($file, "r"); 
 while (!feof ($fc))  
 { 
    $buffer = fgets($fc, 4096); 
    $lines[] = $buffer; 
 } 

fclose ($fc); 

//open same file and use "w" to clear file  
$f=fopen($newfile,"w") or die("couldn't open $file"); 

/**
print_r($lines); 
print "<br>\n"; 
*/
print "Poll successfully created!";

//loop through array using foreach 
foreach($lines as $line) 
{ 
       fwrite($f,$line); //place $line back in file     
    if (strstr($line,$key)){ //look for $key in each line 
    fwrite($f,$newline."\n"); 
    } //place $line back in file  
} 
fclose($f); 

copy($newfile, $file) or exit("failed to copy $newfile"); 

?>
