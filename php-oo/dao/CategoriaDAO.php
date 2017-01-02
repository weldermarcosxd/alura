<?php
  class CategoriaDAO
  {
    private $conexao;

    public function __construct($conexao)
    {
        $this->conexao = $conexao;
    }

    public function findList()
    {
        $categoriaList = [];
        $query = "select * from categoria";
        $result = mysqli_query($this->conexao, $query);
        echo mysqli_error($this->conexao);
        while ($categorias = mysqli_fetch_assoc($result)) {
            $categoria = new Categoria();
            $categoria->setId($categorias["id"]);
            $categoria->setNome($categorias["nome"]);
            array_push($categoriaList, $categoria);
        }
        return $categoriaList;
    }
  }
