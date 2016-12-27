<?php

    include('cabecalho.php');
    include('connect.php');
    include("ProdutoDAO.php");

?>

<?php

    if (array_key_exists('removido', $_GET) && $_GET['removido'] === 'true') {
        ?>
            <p class="alert-success">Produto com removido com sucesso!</p>
        <?php
    }

 ?>

    <table class="table table-striped table-bordered table-hover">
        <thead>
            <th>Id</th>
            <th>Nome</th>
            <th>Preço</th>
            <th>Descrição</th>
            <th>Categoria</th>
            <th>Remover</th>
        </thead>
        <tbody>
        <?php

        $produtoList = findList($conexao);
        foreach ($produtoList as $produto) {
        ?>
            <tr>
                <td><?= $produto['id'] ?></td>
                <td><?= $produto['nome'] ?></td>
                <td><?= $produto['preco'] ?></td>
                <td><?= substr($produto['descricao'], 0 , 45) ?></td>
                <td><?= $produto['categoria_nome'] ?></td>
                <td><form action="remove-produto.php" method="post">
                    <input type="hidden" name="id" value="<?= $produto['id'] ?>">
                    <button class="btn btn-danger">Remover</button>
                </form></td>
            </tr>
        <?php
        }
         ?>
        </tbody>
    </table>

<?php include 'footer.php'; ?>
