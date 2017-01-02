<?php

  class ProdutoFactory{

    private $classes = array('Ebook', 'LivroFisico');

    public function criaPor($tipoProduto, $params) {

        $nome = $params['nome'];
        $preco = $params['preco'];
        $descricao = $params['descricao'];
        $categoria = new Categoria();
        $usado = $params['usado'];

        if (in_array($tipoProduto, $this->classes)) {
             $produto = new $tipoProduto();
             $produto->setNome($nome);
             $produto->setPreco($preco);
             $produto->setDescricao($descricao);
             $produto->setCategoria($categoria);
             $produto->setUsado($usado);
             $produto->setTipoProduto($tipoProduto);
             return $produto;
        }

        $produto = new LivroFisico();
        $produto->setNome($nome);
        $produto->setPreco($preco);
        $produto->setDescricao($descricao);
        $produto->setCategoria($categoria);
        $produto->setUsado($usado);
        $produto->setTipoProduto($tipoProduto);
        return $produto;
    }
  }
