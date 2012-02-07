<?php 

//Insert into config.php
$poll_id = $_GET["poll_id"]; 

$key = 'include ("head.html");'; 
$newline = 'show_vote_control("'.$poll_id.'");'; 

//copy file to prevent double entry 
$file = "example.php"; 
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
