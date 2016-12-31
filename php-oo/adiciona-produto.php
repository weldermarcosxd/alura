<?php
    require_once("cabecalho.php");
    require_once 'dao/ProdutoDAO.php';
    require_once 'model/UsuarioRepositorio.php';

    verificaUsuario();

    $produto = new Produto();
    $categoria = new Categoria();

    $produto->setNome($_POST["nome"]);
    $produto->setPreco($_POST["preco"]);
    $produto->setDescricao($_POST["descricao"]);
    $categoria->setId($_POST["categoria"]);
    $produto->setCategoria($categoria);
    $produto->setUsado(isset($_POST['usado']) ? 1 : 0);


    if(insereNoBanco($conexao, $produto)){
        ?><p class="text-success">O produto <?php $produto->getNome() ?>, <?php $produto->getPreco() ?> foi inserido com sucesso!</p> <?php
    }else{
        $msg = mysqli_error($conexao);
        ?><p class="text-danger">O produto <?php $produto->getNome() ?>, <?php $produto->getPreco() ?> não pode ser inserido!<br> <?=$msg ?></p> <?php
    }
?>
<? php require_once("footer.php"; ?>
()
