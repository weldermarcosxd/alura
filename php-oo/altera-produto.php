<?php
    require_once("cabecalho.php");
    require_once("ProdutoDAO.php");
    require_once("UsuarioRepositorio.php");

    verificaUsuario();

    $produto = new Produto();

    $produto->id = $_POST["id"];
    $produto->nome = $_POST["nome"];
    $produto->preco = $_POST["preco"];
    $produto->descricao = $_POST["descricao"];
    $produto->categoria = $_POST["categoria"];
    $produto->usado = isset($_POST['usado']) ? 1 : 0;

    if(atualizaNoBanco($conexao, $produto)){
        ?><p class="text-success">O produto <?php $produto->nome ?>, <?php $produto->preco ?> foi alterado com sucesso!</p> <?php
    }else{
        $msg = mysqli_error($conexao);
        ?><p class="text-danger">O produto <?php $produto->nome ?>, <?php $produto->preco ?> não pode ser inserido!<br> <?=$msg ?></p> <?php
    }
?>
<? php require_once("footer.php"; ?>
