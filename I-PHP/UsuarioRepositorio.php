<?php

session_start();

function usuarioEstaLogado() {
    return isset($_SESSION["usuarioLogado"]);
}

function verificaUsuario() {
  if(!usuarioEstaLogado()) {
     header("Location: index.php?falhaDeSeguranca=true");
     die();
  }
}

function usuarioLogado() {
    return $_SESSION["usuarioLogado"];
}

function authorize($email){
   $_SESSION["usuarioLogado"] = $email;
}

function logout(){
  session_destroy();
  header("Location: index.php?logout=true");
  die();
}
