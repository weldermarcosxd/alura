<?php
include 'cabecalho.php';
include 'connect.php';
include 'CategoriaDAO.php';
include 'ProdutoDAO.php';

$categoriaList = findList($conexao);
$produto = findById($conexao, $_GET["id"]);
?>

<h1>Altera Produto</h1>

<form action="altera-produto.php" method="post">
    <table class="table">
        <tr>
            <td>Id:</td>
            <td><input type="text" class="form-group" name="id" value="<?=$produto['id'] ?>" readonly="true"></td>
        </tr>
        <tr>
            <td>Nome:</td>
            <td><input type="text" class="form-group" name="nome" value="<?=$produto['nome'] ?>"></td>
        </tr>
        <tr>
            <td>Preco:</td>
            <td><input type="number" class="form-group" name="preco" value="<?=$produto['preco'] ?>"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="checkbox" class="form-group" name="usado" value="true" checked="<?=$produto['usado'] ?>"> Usado</td>
        </tr>
        <tr>
            <td>Categoria:</td>
            <td>
                <select name="categoria" class="form-group">
        <?php
            foreach ($categoriaList as $categoria) {
                ?>
                <option value="<?=$produto['categoria'] ?>"><?=$produto['categoria_nome'] ?></option>
        <?php

            }
        ?>
                </select>
            </td>
        </tr>
        <tr class="form-group">
            <td>Descrição:</td>
            <td><textarea name="descricao" rows="3" class="form-control"><?=$produto['descricao'] ?></textarea></td>
        </tr>
        <td><input type="submit" class="btn btn-primary"  class="form-group" value="Alterar"></td>
    </table>
</form>
<?php include './footer.php'; ?>
