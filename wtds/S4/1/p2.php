<?php
echo "<br> Number: ".$_COOKIE["no"];
echo "<br> Name: ".$_COOKIE["name"];
echo "<br> Address: ".$_COOKIE["adr"];
echo "<br><br>";
echo "<table border=1> <tr> <th> Details </th><th>Values</th></tr>";
echo "<tr> <td> Basic </td><td>".$_POST["basic"]."</td></tr>";
echo "<tr> <td> HRA </td><td>".$_POST["hra"]."</td></tr>";
echo "<tr> <td> DA </td><td>".$_POST["da"]."</td></tr>";
echo "<br><br>";
$total = $_POST["basic"]+$_POST["hra"]+$_POST["da"];
echo "<br>TOTAL: ".$total;
?>