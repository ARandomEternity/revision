<?php
    $xml=simplexml_load_file("xml") or die ("cannot load");
    $xmlstring=$xml->asXML();
    echo "xml filename:".$xml->getName()."<br><br><br>";
    echo "<table border=2 cellpadding=5>";
    echo "<tr><th>any movie</th>";
    
?>