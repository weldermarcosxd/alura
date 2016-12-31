<?php
  require_once('connect.php');

    function insereNoBanco($conexao ,$nome, $preco, $descricao, $categoria, $usado){
      $nome = mysqli_real_escape_string($conexao, $nome);
      $descricao = mysqli_real_escape_string($conexao, $descricao);
      $preco = mysqli_real_escape_string($conexao, $preco);
      $query = "insert into produto (nome, preco, descricao, categoria, usado) values ('{$nome}', {$preco}, '{$descricao}', {$categoria}, {$usado})";
      return mysqli_query($conexao, $query);
    }

    function atualizaNoBanco($conexao, $id, $nome, $preco, $descricao, $categoria, $usado){
      $nome = mysqli_real_escape_string($conexao, $nome);
      $descricao = mysqli_real_escape_string($conexao, $descricao);
      $preco = mysqli_real_escape_string($conexao, $preco);
      $query = "update produto set nome = '{$nome}', preco = {$preco}, descricao = '{$descricao}', categoria = {$categoria}, usado = {$usado} where id = {$id}";
      return mysqli_query($conexao, $query);
    }

    function removerDoBanco($conexao ,$id){
        $query = "delete from produto where id = {$id}";
        return mysqli_query($conexao, $query);
    }

    function findListProduto($conexao){
        $produtoList = [];
        $query = "select produto.*, categoria.nome as categoria_nome from produto join categoria on produto.categoria = categoria.id";
        $result = mysqli_query($conexao, $query);

        echo mysqli_error($conexao);

        while ($produto = mysqli_fetch_assoc($result)) {
            array_push($produtoList, $produto);
        }

        return $produtoList;
    }

    function findById($conexao, $id){
        $produtoList = [];
        $query = "select produto.*, categoria.nome as categoria_nome from produto join categoria on produto.categoria = categoria.id where produto.id = {$id}";
        $result = mysqli_query($conexao, $query);

        echo mysqli_error($conexao);

        $produto = mysqli_fetch_assoc($result);

        return $produto;
    }
