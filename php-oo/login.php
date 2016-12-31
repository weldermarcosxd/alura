<?php
    require_once("cabecalho.php");
    require_once("UsuarioDAO.php");
    require_once("UsuarioRepositorio.php");

    $email = $_POST["email"];
    $pass = $_POST["pass"];

    if(validaLogin($conexao,$email,$pass) == null){
      $_SESSION["danger"] = "Falha na autenticação!";
      header("Location: index.php");
    }else {
      $_SESSION["success"] = "Login realizado com successo!";
      header("Location: index.php");
      authorize($email);
    }
    die();
?>
<? php require_once("footer.php"; ?>
