<?php
    $xml=simplexml_load_file("bookstore.xml") or die ("cannot load");
    $xmlstring=$xml->asXML();
    echo $xmlstring;
?>