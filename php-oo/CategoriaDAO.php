<?php
  require_once('connect.php');
  require_once("entity/Categoria.php");

    function findList($conexao){
        $categoriaList = [];
        $query = "select * from categoria";
        $result = mysqli_query($conexao, $query);

        echo mysqli_error($conexao);

        while ($categorias = mysqli_fetch_assoc($result)) {

          $categoria = new Categoria();

          $categoria->id = $categorias["id"];
          $categoria->nome = $categorias["nome"];

          array_push($categoriaList, $categoria);
        }

        return $categoriaList;
    }
