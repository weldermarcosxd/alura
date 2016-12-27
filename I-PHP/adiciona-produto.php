<?php
    include("cabecalho.php");
    include('connect.php');
    include("ProdutoDAO.php");

    $nome = $_POST["nome"];
    $preco = $_POST["preco"];
    $descricao = $_POST["descricao"];
    $categoria = $_POST["categoria"];


    if(insereNoBanco($conexao, $nome, $preco, $descricao, $categoria)){
        ?><p class="text-success">O produto <?php $nome ?>, <?php $preco ?> foi inserido com sucesso!</p> <?php
    }else{
        $msg = mysqli_error($conexao);
        ?><p class="text-danger">O produto <?php $nome ?>, <?php $preco ?> não pode ser inserido!<br> <?=$msg ?></p> <?php
    }
?>
<? php include("footer.php"; ?>
