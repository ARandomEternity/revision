<?php
    if(isset($_COOKIE['cnt'])){
    $x = $_COOKIE['cnt'];
    $x = $x + 1;
    setcookie('cnt', $x);
    }
    else{
    setcookie('cnt', 1);
    echo "accessed the page 1st time";
    }
echo "accessed the page $x time";
?>


