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
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
            margin: 5%;
        }
        .upload {
            margin: 10px;
            overflow: hidden;
            background: #eeeeee;
        }
    </style>
  </head>

    <body>
        <h1>Images uploaded</h1>
        <div class="row">
        <?php
            $row = 1;
            if (($handle = fopen("images.csv", "r")) !== FALSE) {
                while (($data = fgetcsv($handle, 0, ",")) !== FALSE) {
                    $row++;
        ?>
                    <div class="upload col-sm-5 col-md-3 col-lg-2 well-sm text-center">
                        <p class='imageId'>Image ID: <?php echo $data[0]; ?></p>
                        <a href='<?php echo $data[1]; ?>'>
                            <img src='<?php echo $data[1]; ?>'
                                class='img-image' width="150" height="150" />
                        </a>
                        <p class='deleteHash'>
                            Delete Hash: <br>
                            <span class="label label-danger"><?php echo $data[2]; ?></span>
                        </p>
                        <hr />
                    </div>
        <?php
                }
                fclose($handle);
                echo "</div>";
                echo $row . " images";
            }
        ?>
   </body>

</html>
