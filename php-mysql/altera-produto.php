<?php
    require_once("cabecalho.php");
    require_once("ProdutoDAO.php");
    require_once("UsuarioRepositorio.php");

    verificaUsuario();

    $id = $_POST["id"];
    $nome = $_POST["nome"];
    $preco = $_POST["preco"];
    $descricao = $_POST["descricao"];
    $categoria = $_POST["categoria"];
    $usado = isset($_POST['usado']) ? 1 : 0;


    if(atualizaNoBanco($conexao, $id, $nome, $preco, $descricao, $categoria, $usado)){
        ?><p class="text-success">O produto <?php $nome ?>, <?php $preco ?> foi alterado com sucesso!</p> <?php
    }else{
        $msg = mysqli_error($conexao);
        ?><p class="text-danger">O produto <?php $nome ?>, <?php $preco ?> não pode ser inserido!<br> <?=$msg ?></p> <?php
    }
?>
<? php require_once("footer.php"; ?>