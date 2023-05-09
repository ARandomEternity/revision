<!DOCTYPE html>
<html>
<body>
	<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	</script>
	
	<script>

		$(document).ready(function()
		{
			$("#btn1").click(function()
			{
				$("#im").before("text");
			});
			$("#btn2").click(function()
			{
				$("#im").after("text");
			});
		});
	</script>
	<img id="im" src = "ss.png" width=200px height=200px></img>
	<button id="btn1"> Before </button>
	<button id="btn2"> After </button>
</body>
</html>
