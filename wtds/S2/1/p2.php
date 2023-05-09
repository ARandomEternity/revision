<!DOCTYPE html>
<html>
    <head>
        <form action ="p3.php" method = "POST">
            <input type ='submit' name='submit' value='Submit'/>
</form>
    </head>
    </html>
<?php
    $fs = $_POST['fstyle'];
    $fc = $_POST['fcolor'];
    $bc = $_POST['bcolor'];
    $fst = $_POST['fsize'];
    setcookie("set1", $fs, time() + 3600);
    setcookie("set2", $fc, time() + 3600);
    setcookie("set3", $bc, time() + 3600);
    setcookie("set4", $fst, time() + 3600);
    echo "STYLE:$fs<br>";
    echo "COlOR:$fc<br>";
    echo "backgroundcolor: $bc<br>";
    echo "size: $fst<br>";
?>