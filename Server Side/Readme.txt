SnapVote Server Side Manual:

To set up a new website to support the android app, please simply copy all the files to your directory; don¡¯t forget to change the Server URL in /res/value/string.xml in Android Side.
If you would like to change the name of config.php to ensure the security of your data, please do so in corresponding place in poll/insert.php, poll/poll.php.
If you wish to reset the current vote in a poll, please delete the corresponding data files in poll/data. 
If you wish to delete all the information (polls, votes), please remove all code after line 59 in poll/config.php, all code start with ¡°show_vote_control¡± in allVotes.php and then empty the poll/data folder.
Here is a brief introduction to every file in this source code:
root/
createVote.php: Includes the form shown when creating a vote. This creates a vote in Config.php.
allVotes.php: Sample page of votes.
head.html: Includes head information of webpages.
index.html: Homepage.
insert.php: Insert line to allVotes.php when called.
qrcodegen.php: Generate QRCode by calling Google API.

---------------
poll/
class.php: Includes types of poll available to create via webpage.(Currently not enabled).
config.php : Includes all kind of configurations and polls.
insert.php : Inserts lines to config.php when called.
poll.php : Includes all kind of function to manipulate a poll.
results.php:  Shows the current result of a certain poll.
vote.php: Includes actions when add a new rating to a poll.
------------------------------------------
poll/data
*.dat: Databases including poll and vote information. Delete to empty current rates.
-------------------------------------------
poll/template
*.* Includes CSS style and result page.