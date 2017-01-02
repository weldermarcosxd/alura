<?php
    require_once 'cabecalho.php';

    $produtoDAO = new ProdutoDAO($conexao);
 ?>

    <table class="table table-striped table-bordered table-hover">
        <thead>
            <th>Id</th>
            <th>Nome</th>
            <th>Preço</th>
            <th>Impostos</th>
            <th>Descrição</th>
            <th>Usado</th>
            <th>Categoria</th>
            <th>Tipo Produto</th>
            <th>ISBN</th>
            <th>Editar</th>
            <th>Remover</th>
        </thead>
        <tbody>
        <?php

        $produtoList = $produtoDAO->findListProduto();
        foreach ($produtoList as $produto) {
            ?>
            <tr>
                <td><?= $produto->getId() ?></td>
                <td><?= $produto->getNome() ?></td>
                <td><?= $produto->getPreco() ?></td>
                <td><?= $produto->calculaImposto() ?></td>
                <td><?= substr($produto->getDescricao(), 0, 45) ?></td>
                <td><?= $produto->getUsado() == 0 ? 'Não' : 'Sim' ?></td>
                <td><?= $produto->getCategoria()->getNome() ?></td>
                <td><?= $produto->getTipoProduto() ?></td>
                <td><?= $produto->isLivro() ? $produto->getIsbn() : '' ?></td>
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
