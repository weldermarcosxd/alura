<?php
  require_once('db/connect.php');

    function insereNoBanco($conexao ,Produto $produto){
      $produto->setNome(mysqli_real_escape_string($conexao, $produto->getNome()));
      $produto->setDescricao(mysqli_real_escape_string($conexao, $produto->getDescricao()));
      $produto->setPreco(mysqli_real_escape_string($conexao, $produto->getPreco()));
      $query = "insert into produto (nome, preco, descricao, categoria, usado) values ('{$produto->getNome()}', {$produto->getPreco()}, '{$produto->getDescricao()}', {$produto->getCategoria()->getId()}, {$produto->getUsado()})";
      return mysqli_query($conexao, $query);
    }

    function atualizaNoBanco($conexao, Produto $produto){
      $produto->setNome(mysqli_real_escape_string($conexao, $produto->getNome()));
      $produto->setDescricao(mysqli_real_escape_string($conexao, $produto->getDescricao()));
      $produto->setPreco(mysqli_real_escape_string($conexao, $produto->getPreco()));
      $query = "update produto set nome = '{$produto->getNome()}', preco = {$produto->getPreco()}, descricao = '{$produto->getDescricao()}', categoria = {$produto->getCategoria()->getId()}, usado = {$produto->getUsado()} where id = {$produto->getId()}";
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
          $categoria->setNome($produto_arr["categoria_nome"]);
          $categoria->setId($produto_arr["categoria"]);

          $produto->setId($produto_arr["id"]);
          $produto->setNome($produto_arr["nome"]);
          $produto->setPreco($produto_arr["preco"]);
          $produto->setDescricao($produto_arr["descricao"]);
          $produto->setCategoria($categoria);
          $produto->setUsado($produto_arr["usado"]);
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
        $categoria->setNome($produto_arr["categoria_nome"]);
        $categoria->setId($produto_arr["categoria"]);

        $produto->setId($produto_arr["id"]);
        $produto->setNome($produto_arr["nome"]);
        $produto->setPreco($produto_arr["preco"]);
        $produto->setDescricao($produto_arr["descricao"]);
        $produto->setCategoria($categoria);
        $produto->setUsado($produto_arr["usado"]);

        return $produto;
    }
