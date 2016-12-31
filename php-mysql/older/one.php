<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title></title>
    </head>
    <body>
        <?php
            $numeros = array(1,3,9,4,5,8,2,6,7,0);
            echo somaArray($numeros);
            
            function somaArray($array){
                $sum = 0;
                foreach ($array as $key => $value) {
                    $sum = $sum + $value;
                }
                return($sum);
            }
         ?>
    </body>
</html>
