<?php

  class UsuarioDAO{

    private $conexao;

    function __construct($conexao)  {
      $this->conexao = $conexao;
    }

    function findList(){
        $categoriaList = [];
        $query = "select * from categoria";
        $result = mysqli_query($this->conexao, $query);
        echo mysqli_error($this->conexao);
        while ($categoria = mysqli_fetch_assoc($result)) {
            array_push($categoriaList, $categoria);
        }
        return $categoriaList;
    }

    function validaLogin($email, $pass){
      $md5pass = md5($pass);
      $email = mysqli_real_escape_string($this->conexao, $email);
      $query = "select * from usuario where email = '{$email}' and pass = '{$md5pass}'";
      $result = mysqli_query($this->conexao, $query);
      if ($result) {
        $user = mysqli_fetch_assoc($result);
        return $user;
      }else {
        echo mysqli_error($this->conexao);
        die();
      }
    }

  }
