<?php

  require_once 'Categoria.php';

  abstract class Produto
  {
      private $id;
      private $nome;
      private $preco;
      private $descricao;
      private $categoria;
      private $usado;
      private $tipoProduto;

      public function calculaDesconto($desconto = 0.1)
      {
          if ($desconto > 0 && $desconto < 1) {
              $this->preco -= $this->preco * $desconto;
          }
          return $this->preco;
      }

      public function getId()
      {
          return $this->id;
      }

      public function setId($id)
      {
          $this->id = $id;
      }

      public function getNome()
      {
          return $this->nome ;
      }

      public function setNome($nome)
      {
          $this->nome = $nome;
      }

      public function getPreco()
      {
          return $this->preco;
      }

      public function setPreco($preco)
      {
          $this->preco = $preco;
      }

      public function getDescricao()
      {
          return $this->descricao;
      }

      public function setDescricao($descricao)
      {
          $this->descricao = $descricao;
      }

      public function getCategoria()
      {
          return $this->categoria;
      }

      public function setCategoria(Categoria $categoria)
      {
          $this->categoria = $categoria;
      }

      public function getUsado()
      {
          return $this->usado ;
      }

      public function setUsado($usado)
      {
          $this->usado = $usado;
      }

      public function getTipoProduto()
      {
          return $this->tipoProduto ;
      }

      public function setTipoProduto($tipoProduto)
      {
          $this->tipoProduto = $tipoProduto;
      }

      public function isLivro()
      {
          return $this instanceof Livro;
      }

      public function temTaxaImpressao() {
        return $this instanceof LivroFisico;
      }

      public function temWaterMark() {
        return $this instanceof Ebook;
      }

      public function calculaImposto()
      {
          return $this->getPreco() * 0.195;
      }

      public abstract function atualizaBaseadoEm($params);
  }
