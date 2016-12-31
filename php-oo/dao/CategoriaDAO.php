<?php
  require_once 'db/connect.php';

    function findList($conexao){
        $categoriaList = [];
        $query = "select * from categoria";
        $result = mysqli_query($conexao, $query);
        echo mysqli_error($conexao);
        while ($categorias = mysqli_fetch_assoc($result)) {
          $categoria = new Categoria();
          $categoria->setId($categorias["id"]);
          $categoria->setNome($categorias["nome"]);
          array_push($categoriaList, $categoria);
        }
        return $categoriaList;
    }
