<html>
  <head>
    <title>catch</title>
  </head>
  <body>
    <?php
      function func($x, $y){
        if ($y == 0){
          throw new Exception("divided by zero!");
        }
        return $x / $y;
      }
      try{
        $ret = func(6, 0);
      }
      catch(Exception $e){
        echo "Exception!";
      }
      echo "$ret\n";
    ?>
  </body>
</html>
