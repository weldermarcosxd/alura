<?php
    require_once 'cabecalho.php';
    require_once 'dao/ProdutoDAO.php';
 ?>

    <table class="table table-striped table-bordered table-hover">
        <thead>
            <th>Id</th>
            <th>Nome</th>
            <th>Preço</th>
            <th>Preço com desconto</th>
            <th>Descrição</th>
            <th>Usado</th>
            <th>Categoria</th>
            <th>Editar</th>
            <th>Remover</th>
        </thead>
        <tbody>
        <?php

        $produtoList = findListProduto($conexao);
        foreach ($produtoList as $produto) {
            ?>
            <tr>
                <td><?= $produto->getId() ?></td>
                <td><?= $produto->getNome() ?></td>
                <td><?= $produto->getPreco() ?></td>
                <td><?= $produto->calculaDesconto() ?></td>
                <td><?= substr($produto->getDescricao(), 0, 45) ?></td>
                <td><?= $produto->getUsado() == 0 ? 'Não' : 'Sim' ?></td>
                <td><?= $produto->getCategoria()->getNome() ?></td>
                <td><a class="btn btn-primary form-group" href="produto-formulario-alterar.php?id=<?= $produto->getId() ?>">Editar</a></td>
                <td><form action="remove-produto.php" method="post">
                    <input type="hidden" name="id" value="<?= $produto->getId() ?>">
                    <button class="btn btn-danger form-group">Remover</button>
                </form></td>
            </tr>
        <?php

        }
         ?>
        </tbody>
    </table>

<?php require_once 'footer.php'; ?>
