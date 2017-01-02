<?php

require_once 'dao/UsuarioDAO.php';
require_once 'db/connect.php';

session_start();

function usuarioEstaLogado() {
    return isset($_SESSION["usuarioLogado"]);
}

function verificaUsuario() {
  if(!usuarioEstaLogado()) {
    $_SESSION["danger"] = "Você não tem acesso a essa funcionalidade";
    header("Location: index.php");
  }
}

function usuarioLogado() {
    return $_SESSION["usuarioLogado"];
}

function authorize($email){
   $_SESSION["usuarioLogado"] = $email;
}

function validaLogin($conexao,$email, $pass){
  $usuarioDAO = new UsuarioDAO($conexao);
  return $usuarioDAO->validaLogin($email, $pass);
}

function logout(){
  session_destroy();
  session_start();
  $_SESSION["warning"] = "Logout realizado com sucesso!";
  header("Location: index.php");
}
