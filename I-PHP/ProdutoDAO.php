<?php

    function insereNoBanco($conexao ,$nome, $preco, $descricao){
        $query = "insert into produto (nome, preco, descricao) values ('{$nome}', {$preco}, '{$descricao}')";
        return mysqli_query($conexao, $query);
    }

    function removerDoBanco($conexao ,$id){
        $query = "delete from produto where id = {$id}";
        return mysqli_query($conexao, $query);
    }

    function findList($conexao){
        $produtoList = [];
        $query = "select * from produto";
        $result = mysqli_query($conexao, $query);

        echo mysqli_error($conexao);

        while ($produto = mysqli_fetch_assoc($result)) {
            array_push($produtoList, $produto);
        }

        return $produtoList;
    }
