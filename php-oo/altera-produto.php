<?php
    require_once("cabecalho.php");
    require_once 'dao/ProdutoDAO.php';
    require_once 'dao/CategoriaDAO.php';
    require_once 'model/UsuarioRepositorio.php';

    verificaUsuario();

    $produto = new Produto();
    $categoria = new Categoria();

    $produto->setId($_POST["id"]);
    $produto->setNome($_POST["nome"]);
    $produto->setPreco($_POST["preco"]);
    $produto->setDescricao($_POST["descricao"]);
    $categoria->setId($_POST["categoria"]);
    $produto->setCategoria($categoria);
    $produto->setUsado(isset($_POST['usado']) ? 1 : 0);

    if(atualizaNoBanco($conexao, $produto)){
        ?><p class="text-success">O produto <?php $produto->getNome() ?>, <?php $produto->getPreco() ?> foi alterado com sucesso!</p> <?php
    }else{
        $msg = mysqli_error($conexao);
        ?><p class="text-danger">O produto <?php $produto->getNome() ?>, <?php $produto->getPreco() ?> não pode ser inserido!<br> <?=$msg ?></p> <?php
    }
?>
<? php require_once("footer.php"; ?>
