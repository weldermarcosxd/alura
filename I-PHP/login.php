<?php
    include("cabecalho.php");
    include('connect.php');
    include("UsuarioDAO.php");
    include("UsuarioRepositorio.php");

    $email = $_POST["email"];
    $pass = $_POST["pass"];

    if(validaLogin($conexao,$email,$pass) == null){
      header("Location: index.php?logado=0");
    }else {
      header("Location: index.php?logado=1");
      authorize($email);
    }
    die();
?>
<? php include("footer.php"; ?>
