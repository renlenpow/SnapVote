<html>
<head>
<style>
body{
    width:100%;
    margin:0px;
    padding:0px;
}
#container{
    font-family: Arial, serif;
    font-size:12px;
    padding-top:20px;
    width:700px;
    margin: auto;
}
form{
    width:300px;
    padding: 0px;
    margin: 0px;
}
form textarea{
    font-family: Arial, serif;
    font-size:12px;
    width:270px;
    margin:5px;
    height:40px;
    overflow: hidden;
}
iframe{
    border:1px solid #DDD;
}
#generator{
    width: 300px;
    float:left;
}
#generator fieldset{
    border:1px solid #DDD;
}
#result{
    padding-top:7px;
    margin-left:340px;
    width: 350px;
}
</style>
</head>
 
<body>
<div id="container">
    <h1>Create Your Vote!</h1>
    <div id="createVote">
        <form target="vote-gen" action="gen.php" method="post">
	Topic of Vote
		<input type="text" size="12" maxlength="60" name="topic">:<br/>
	Number of Options(Max. 5)
		<input type="text" size="12" maxlength="1" name="nOption">:<br/>
	Option 1
		<input type="text" size="12" maxlength="50" name="option1">:<br/>
	Option 2
		<input type="text" size="12" maxlength="50" name="option2">:<br/>
	Option 3
		<input type="text" size="12" maxlength="50" name="option3">:<br/>
	Option 4
		<input type="text" size="12" maxlength="50" name="option4">:<br/>
	Option 5
		<input type="text" size="12" maxlength="50" name="option5">:<br/>
	Secret Pass You Create to Access Your Vote(Numerical)
		<input type="text" size="12" maxlength="10" name="poll_id">:<br/>
		<fieldset>
			    <legend>Size:</legend>
			     <input type="radio" name="size" value="150x150" checked>150x150<br>
			     <input type="radio" name="size" value="200x200">200x200<br>
			     <input type="radio" name="size" value="250x250">250x250<br>
			     <input type="radio" name="size" value="300x300">300x300<br>
			  </fieldset>
		</form><br/>
          <input type="submit" value="Submit"></input>
        </form>
    </div>
    <div id="result">
        <iframe name="vote-gen" frameborder="0"  id="qrcode" src="qrcodegen.php" height="315px;" width="350px"></iframe>
    </div>
</div>
 
</body>
</html>
