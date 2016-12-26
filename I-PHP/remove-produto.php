<?php
    include("cabecalho.php");
    include('connect.php');
    include("ProdutoDAO.php");

    $id = $_POST["id"];

    if(removerDoBanco($conexao, $id)){
        header("Location:  lista-produto.php?removido=true");
        die();
    }else{
        $msg = mysqli_error($conexao);
        ?><p class="text-danger">O produto com id:<?php $id ?> não pode ser inserido!<br> <?=$msg ?></p> <?php
    }
?>
<? php include("footer.php"; ?>
