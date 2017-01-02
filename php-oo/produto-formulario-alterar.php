<?php
  require_once 'cabecalho.php';
  require_once 'model/UsuarioRepositorio.php';

  $produtoDAO = new ProdutoDAO($conexao);
  $categoriaDAO = new CategoriaDAO($conexao);

  $categoriaList = $categoriaDAO->findList($conexao);
  $produto = $produtoDAO->findById($_GET["id"]);

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
