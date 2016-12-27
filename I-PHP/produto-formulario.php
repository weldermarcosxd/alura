<?php
include 'cabecalho.php';
include 'connect.php';
include 'CategoriaDAO.php';

$categoriaList = findList($conexao);
?>
<form action="adiciona-produto.php" method="post">
    <table>
        <tr>
            <td>Nome:</td>
            <td><input type="text" class="form-group" name="nome"></td>
        </tr>
        <tr class="form-group">
            <td>Preco:</td>
            <td><input type="number" class="form-group" name="preco"></td>
        </tr>
        <tr>
            <td>Categoria:</td>
            <td>
        <?php
            foreach ($categoriaList as $categoria) {
        ?>
            <input class="form-group" type="radio" name="categoria" value="<?=$categoria['id']?>"><?=$categoria['nome']?><br>
        <?php
            }
        ?>
        </td>
        </tr>
        <tr class="form-group">
            <td>Descrição:</td>
            <td><textarea name="descricao" rows="3" class="form-control"></textarea></td>
        </tr>
        <td><input type="submit" class="btn btn-primary"  value="Cadastrar"></td>
    </table>
</form>
<?php include './footer.php'; ?>
