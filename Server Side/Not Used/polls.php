<?php
// Third poll definition
$p = new Poll;
$p->question = "What is your favorite PHP script?";	// Question displayed to the user
$p->returnToURL = "../example.php";				// Specify the URL to return to for this poll; may be relative or absolute
$p->legend = "Third Poll";						// Form legend; leave empty for none
$p->control_type = $CONTROL_RADIOBUTTONS;		// Control type; $CONTROL_RADIOBUTTONS or $CONTROL_COMBOBOX
$p->add_value("1", "PHP Guestbook", "http://www.dbscripts.net/guestbook/");	// You may include the optional URL parameter to create a link
$p->add_value("2", "PHP Poll", "http://www.dbscripts.net/poll/");
$p->add_value("3", "PHP Image Gallery", "http://www.dbscripts.net/imagegallery/");
$p->add_value("4", "PHP Ratings", "http://www.dbscripts.net/ratings/");
$VALID_POLLS["4"] = $p;	
?>
