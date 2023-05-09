<?php
setcookie('no',$_POST['no']);
setcookie('name',$_POST['name']);
setcookie('adr',$_POST['adr']);
?>
<html>
    <form action= "p2.php" method = "POST">
        <br>
        Enter details: <br><br>
        Basic Salary: <input type ="text" name = "basic" size = "3">
        HRA: <input type ="text" name = "hra" size = "3">
        DA: <input type ="text" name = "da" size = "3">
        <input type = "submit" value ="DISPLAY INFO">
</form>
</html>