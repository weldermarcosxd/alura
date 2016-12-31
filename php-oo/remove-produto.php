<?php
    require_once("cabecalho.php");
    require_once 'dao/ProdutoDAO.php';
    require_once 'model/UsuarioRepositorio.php';

    $id = $_POST["id"];

    if(removerDoBanco($conexao, $id)){
        $_SESSION["success"] = "Produto removido com sucesso!";
        header("Location:  lista-produto.php");
    }else{
        $msg = mysqli_error($conexao);
        $_SESSION["danger"] = "O produto com id: {$id} não pode ser removido! '{$msg}'";
        header("Location:  lista-produto.php");
    }
?>
<? php require_once("footer.php"; ?>
