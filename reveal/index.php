<?php
    header('Access-Control-Allow-Origin: *');
    if ( $_GET['imageId'] &&  $_GET['link'] && $_GET['deleteHash'] ) {
        $imageId =  $_GET['imageId'];
        $link = $_GET['link'];
        $deleteHash = $_GET['deleteHash'];


        $fp = fopen('images.csv', 'a');
        fputcsv($fp, array($imageId, $link, $deleteHash));
        fclose($fp);
    }
?>



<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Save Image Hash</title>
  </head>

    <body>
        Images:
        <?php
            $row = 1;
            if (($handle = fopen("images.csv", "r")) !== FALSE) {
                while (($data = fgetcsv($handle, 0, ",")) !== FALSE) {
                    $num = count($data);
                    echo "<p> $num fields in line $row: <br /></p>\n";
                    $row++;
                    for ($c=0; $c < $num; $c++) {
                        echo $data[$c] . "<br />\n";
                    }
                }
                fclose($handle);
            }
        ?>
   </body>

</html>
