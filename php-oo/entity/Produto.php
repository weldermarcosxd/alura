<?php

  class Produto
  {
      public $id;
      public $nome;
      public $preco;
      public $descricao;
      public $categoria;
      public $usado;

      public function __construct($id,$nome,$preco,$descricao,$categoria,$usado){
        $this->id = $id;
        $this->nome = $nome;
        $this->preco = $preco;
        $this->descricao = $descricao;
        $this->categoria = $categoria;
        $this->usado = $usado;
      }
  }
