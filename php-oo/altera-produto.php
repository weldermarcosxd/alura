<?php
    require_once("cabecalho.php");
    require_once 'model/UsuarioRepositorio.php';

    $categoriaDAO = new CategoriaDAO($conexao);
    $produtoDAO = new ProdutoDAO($conexao);

    verificaUsuario();

    $id = $_POST["id"];
    $tipoProduto = $_POST['tipoProduto'];
    $categoria_id = $_POST['categoria'];

    $factory = new ProdutoFactory();
    $produto = $factory->criaPor($tipoProduto, $_POST);
    $produto->atualizaBaseadoEm($_POST);

    $produto->setId($id);
    $produto->getCategoria()->setId($categoria_id);

    if(array_key_exists('usado', $_POST)) {
        $produto->setUsado(1);
    } else {
        $produto->setUsado(0);
    }

    if($produtoDAO->atualizaNoBanco($produto)){
        ?><p class="text-success">O produto <?php $produto->getNome() ?>, <?php $produto->getPreco() ?> foi alterado com sucesso!</p> <?php
    }else{
        $msg = mysqli_error($conexao);
        ?><p class="text-danger">O produto <?php $produto->getNome() ?>, <?php $produto->getPreco() ?> não pode ser inserido!<br> <?=$msg ?></p> <?php
    }
?>
<? php require_once("footer.php"; ?>
