<?php

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

    function validaLogin($conexao, $email, $pass){
      $md5pass = md5($pass);
      $query = "select * from usuario where email = '{$email}' and pass = '{$md5pass}'";
      $result = mysqli_query($conexao, $query);
      $user = mysqli_fetch_assoc($result);
      return $user;
    }
