<!DOCTYPE html>
<html>
<body>
	<form>
		<input id="text1" type='text' placeholder='username'></input><br>
		<input id="text2" type='password' placeholder='password'></input><br>
		<input type ="button" value ="login" onclick="javascript:validate()">
	</form>
	<script type = "text/javascript">
		function validate(){
		if(document.getElementById("text1").value == "user" && document.getElementById("text2").value == "password"){
			alert("succeeded");
		}
		else{
			alert("failed");
		}
		}
	</script>
</body>
</html>
