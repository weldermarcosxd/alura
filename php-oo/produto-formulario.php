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
        <?php require_once("formulario-base.php") ?>
        <td><input type="submit" class="btn btn-primary"  value="Cadastrar"></td>
    </table>
</form>
<?php require_once './footer.php'; ?>
