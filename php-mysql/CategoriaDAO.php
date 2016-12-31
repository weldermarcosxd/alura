<?php
  require_once('connect.php');

    function findList($conexao){
        $categoriaList = [];
        $query = "select * from categoria";
        $result = mysqli_query($conexao, $query);

        echo mysqli_error($conexao);

        while ($categoria = mysqli_fetch_assoc($result)) {
            array_push($categoriaList, $categoria);
        }

        return $categoriaList;
    }
