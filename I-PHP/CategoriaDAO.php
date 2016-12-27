<?php

    // function insereNoBanco($conexao ,$nome, $preco, $descricao){
    //     $query = "insert into produto (nome, preco, descricao) values ('{$nome}', {$preco}, '{$descricao}')";
    //     return mysqli_query($conexao, $query);
    // }
    //
    // function removerDoBanco($conexao ,$id){
    //     $query = "delete from produto where id = {$id}";
    //     return mysqli_query($conexao, $query);
    // }

    function findList($conexao){
        $categoriaList = [];
        $query = "select * from categoria";
        $result = mysqli_query($conexao, $query);

        echo mysqli_error($conexao);

        while ($categoria = mysqli_fetch_assoc($result)) {
            array_push($categoriaList, $categoria);
        }

        return $categoriaList;
    }
