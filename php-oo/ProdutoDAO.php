<?php
  require_once('connect.php');
  require_once("entity/Produto.php");
  require_once("entity/Categoria.php");

    function insereNoBanco($conexao ,Produto $produto){
      $produto->nome = mysqli_real_escape_string($conexao, $produto->nome);
      $produto->descricao = mysqli_real_escape_string($conexao, $produto->descricao);
      $produto->preco = mysqli_real_escape_string($conexao, $produto->preco);
      $query = "insert into produto (nome, preco, descricao, categoria, usado) values ('{$produto->nome}', {$produto->preco}, '{$produto->descricao}', {$produto->categoria->id}, {$produto->usado})";
      return mysqli_query($conexao, $query);
    }

    function atualizaNoBanco($conexao, Produto $produto){
      $produto->nome = mysqli_real_escape_string($conexao, $produto->nome);
      $produto->descricao = mysqli_real_escape_string($conexao, $produto->descricao);
      $produto->preco = mysqli_real_escape_string($conexao, $produto->preco);
      $query = "update produto set nome = '{$produto->nome}', preco = {$produto->preco}, descricao = '{$produto->descricao}', categoria = {$produto->categoria}, usado = {$produto->usado} where id = {$produto->id}";
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
        while ($produto_arr = mysqli_fetch_assoc($result)) {
          $produto = new Produto();
          $categoria = new Categoria();
          $categoria->nome = $produto_arr["categoria_nome"];

          $produto->id = $produto_arr["id"];
          $produto->nome = $produto_arr["nome"];
          $produto->preco = $produto_arr["preco"];
          $produto->descricao = $produto_arr["descricao"];
          $produto->categoria = $categoria;
          $produto->usado = $produto_arr["usado"];

          array_push($produtoList, $produto);
        }
        return $produtoList;
    }

    function findById($conexao, $id){
        $produtoList = [];
        $query = "select produto.*, categoria.nome as categoria_nome from produto join categoria on produto.categoria = categoria.id where produto.id = {$id}";
        $result = mysqli_query($conexao, $query);
        echo mysqli_error($conexao);
        $produto_arr = mysqli_fetch_assoc($result);

        $produto = new Produto();
        $categoria = new Categoria();
        $categoria->nome = $produto_arr["categoria_nome"];

        $produto->id = $produto_arr["id"];
        $produto->nome = $produto_arr["nome"];
        $produto->preco = $produto_arr["preco"];
        $produto->descricao = $produto_arr["descricao"];
        $produto->categoria = $categoria;
        $produto->usado = $produto_arr["usado"];

        return $produto;
    }
