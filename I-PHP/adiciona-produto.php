<?php include("cabecalho.php"); ?>
<?php
    $nome = $_GET["nome"];
    $preco = $_GET["preco"];

    $conexao = mysqli_connect( "localhost", "root", "root", "loja");
    $query = "insert into produto (nome, preco) values ('{$nome}', {$preco})";

    if(mysqli_query($conexao, $query)){
        ?><p class="alert-success">O produto <?php $nome ?>, <?php $preco ?> foi inserido com sucesso!</p> <?php
    }else{
        ?><p class="alert-danger">O produto <?php $nome ?>, <?php $preco ?> não pode ser inserido!</p> <?php
    }
    mysqli_close($conexao);
?>
<? php include("footer.php"; ?>
