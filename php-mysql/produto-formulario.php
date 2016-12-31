<?php
require_once 'cabecalho.php';
require_once 'CategoriaDAO.php';
require_once("UsuarioRepositorio.php");

$categoriaList = findList($conexao);
$produto = array('nome' => "", 'preco' => "", 'descricao' => "", 'categoria' => 1 );
$usado = 0;

verificaUsuario();

?>

<h1>Adiciona Produto</h1>
<form action="adiciona-produto.php" method="post">
    <table class="table">
        <tr>
            <td>Nome:</td>
            <td><input type="text" class="form-group" name="nome"></td>
        </tr>
        <tr class="form-group">
            <td>Preco:</td>
            <td><input type="number" class="form-group" name="preco"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="checkbox" name="usado" value="true"> Usado</td>
        </tr>
        <tr>
            <td>Categoria:</td>
            <td>
                <select name="categoria" class="form-group">
        <?php
            foreach ($categoriaList as $categoria) {
                ?>
                <option value="<?=$categoria['id']?>"><?=$categoria['nome']?></option>
        <?php

            }
        ?>
                </select>
            </td>
        </tr>
        <tr class="form-group">
            <td>Descrição:</td>
            <td><textarea name="descricao" rows="3" class="form-control"></textarea></td>
        </tr>
        <td><input type="submit" class="btn btn-primary"  value="Cadastrar"></td>
    </table>
</form>
<?php require_once './footer.php'; ?>
