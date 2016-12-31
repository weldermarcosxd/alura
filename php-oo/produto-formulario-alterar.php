<?php
  require_once 'cabecalho.php';
  require_once 'dao/CategoriaDAO.php';
  require_once 'dao/ProdutoDAO.php';
  require_once 'model/UsuarioRepositorio.php';
  require_once 'entity/Produto.php';
  require_once 'entity/Categoria.php';

  $categoriaList = findList($conexao);
  $produto = findById($conexao, $_GET["id"]);

  verificaUsuario();
?>

<h1>Altera Produto</h1>

<form action="altera-produto.php" method="post">
    <table class="table">
        <tr>
            <td>Id:</td>
            <td><input type="text" class="form-group" name="id" value="<?=$produto->getId() ?>" readonly="true"></td>
        </tr>
        <?php require_once("formulario-base.php") ?>
        <td><input type="submit" class="btn btn-primary"  class="form-group" value="Alterar"></td>
    </table>
</form>
<?php require_once './footer.php'; ?>
