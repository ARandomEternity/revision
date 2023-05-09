<?php
$u=$_POST['u'];
$p=$_POST['p'];
session_start();
if(isset($_SESSION[$u]))
{
    $val=$_SESSION[$u];
    $val++;
    $_SESSION[$u]=$val;
}
else{
    $_SESSION[$u]=1;
}
if($_SESSION[$u]>4)
die("attempt is over");
if($p==123)
echo"welcome";
else
echo"invalid info";
?> 