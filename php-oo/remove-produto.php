<?php
    require_once("cabecalho.php");
    require_once("ProdutoDAO.php");
    require_once('UsuarioRepositorio.php');

    $id = $_POST["id"];

    if(removerDoBanco($conexao, $id)){
        $_SESSION["success"] = "Produto removido com sucesso!";
        header("Location:  lista-produto.php");
    }else{
        $msg = mysqli_error($conexao);
        $_SESSION["danger"] = "O produto com id: {$id} não pode ser inserido! {$msg}";
        header("Location:  lista-produto.php");
    }
?>
<? php require_once("footer.php"; ?>
