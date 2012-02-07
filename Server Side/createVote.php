<!DOCTYPE html 
     PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Poll Test</title>
<link href="poll/template/styles.css" rel="stylesheet" type="text/css" />
</head>
<body>

<h1>SnapVote!</h1>


<p>
Let's Go!
</p>

<?php 
/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */

$topic = $_POST["topic"];
$nOption = $_POST["nOption"];
$option1 = $_POST["option1"];
$option2 = $_POST["option2"];
$option3 = $_POST["option3"];
$option4 = $_POST["option4"];
$option5 = $_POST["option5"];
$size = $_POST["size"];
$poll_id = $_POST["poll_id"];


if (!isset($_POST['submit'])) { // if page is not submitted to itself echo the form
?>

<form method="post" action="<?php echo $PHP_SELF;?>">
Topic of Vote<input type="text" size="12" maxlength="60" name="topic">:<br/>
Number of Options(Max. 5)<input type="text" size="12" maxlength="1" name="nOption">:<br/>
Option 1<input type="text" size="12" maxlength="50" name="option1">:<br/>
Option 2<input type="text" size="12" maxlength="50" name="option2">:<br/>
Option 3<input type="text" size="12" maxlength="50" name="option3">:<br/>
Option 4<input type="text" size="12" maxlength="50" name="option4">:<br/>
Option 5<input type="text" size="12" maxlength="50" name="option5">:<br/>

Secret Pass You Create to Access Your Vote(Numerical)
		<input type="text" size="12" maxlength="10" name="poll_id">:<br/>
<fieldset>
		<legend>Size:</legend>
		<input type="radio" name="size" value="150x150" checked>150x150<br>
		<input type="radio" name="size" value="200x200">200x200<br>
		<input type="radio" name="size" value="250x250">250x250<br>
		<input type="radio" name="size" value="300x300">300x300<br>
			  </fieldset>
<input type="submit" value="submit" name="submit"><br />
</form><br/>

<?
} else {


echo '<a href="http://m-yl.us/lab/vote/poll/poll/insert.php?topic='.$topic.'&nOption='.$nOption.'&option1='.$option1.'&option2='.$option2.'&option3='.$option3.'&option4='.$option4.'&option5='.$option5.'&poll_id='.$poll_id.'"> Click Me to Proceed</a>';

echo '<a href="http://m-yl.us/lab/vote/poll/qrcodegen.php?size='.$size.'&option1='.$option1.'&option2='.$option2.'&option3='.$option3.'&option4='.$option4.'&option5='.$option5.'&poll_id='.$poll_id.'"> Click Me to Show QRCodes</a>';

echo '<a href="http://m-yl.us/lab/vote/poll/insert.php?poll_id='.$poll_id.'"> Click Me to View Created Vote</a>';


}

?>

