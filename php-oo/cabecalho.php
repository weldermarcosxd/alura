<?php
  error_reporting(E_ALL ^ E_NOTICE);
  require_once("mensagens.php");
  require_once 'db/connect.php';

  function carregaClasse($nomeDaClasse) {
    if(is_file("entity/".$nomeDaClasse.".php")){
      require_once("entity/".$nomeDaClasse.".php");
    }elseif (is_file("dao/".$nomeDaClasse.".php")) {
      require_once("dao/".$nomeDaClasse.".php");
    }
  }

  spl_autoload_register("carregaClasse");
?>
<html>
<head>
    <title>Minha loja</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet" />
    <link href="css/main.css" rel="stylesheet" />
</head>

<body>

    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a href="index.php" class="navbar-brand">Minha Loja</a>
            </div>
            <ul class="nav navbar-nav">
                <li>
                    <a href="lista-produto.php">Listar Produto</a>
                </li>
                <li>
                    <a href="produto-formulario.php">Adicionar Produto</a>
                </li>
                <li>
                    <a href="contato.php">Contato</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="container">
        <div class="principal">
          <?php
            mostraAlertas("success");
            mostraAlertas("danger");
            mostraAlertas("warning");
          ?>
