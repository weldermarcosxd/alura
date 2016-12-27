<?php

    function insereNoBanco($conexao ,$nome, $preco, $descricao, $categoria){
        $query = "insert into produto (nome, preco, descricao, categoria) values ('{$nome}', {$preco}, '{$descricao}', {$categoria})";
        return mysqli_query($conexao, $query);
    }

    function removerDoBanco($conexao ,$id){
        $query = "delete from produto where id = {$id}";
        return mysqli_query($conexao, $query);
    }

    function findList($conexao){
        $produtoList = [];
        $query = "select produto.*, categoria.nome as categoria_nome from produto join categoria on produto.categoria = categoria.id";
        $result = mysqli_query($conexao, $query);

        echo mysqli_error($conexao);

        while ($produto = mysqli_fetch_assoc($result)) {
            array_push($produtoList, $produto);
        }

        return $produtoList;
    }
