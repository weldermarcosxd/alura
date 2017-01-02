<?php
class ProdutoDAO
{
    private $conexao;

    public function __construct($conexao)
    {
        $this->conexao = $conexao;
    }

    public function insereNoBanco(Produto $produto)
    {
      $produto->setNome(mysqli_real_escape_string($this->conexao, $produto->getNome()));
      $produto->setDescricao(mysqli_real_escape_string($this->conexao, $produto->getDescricao()));
      $produto->setPreco(mysqli_real_escape_string($this->conexao, $produto->getPreco()));

      $isbn = "";
      if($produto->isLivro()) {
          $isbn = $produto->getIsbn();
      }

      $waterMark = "";
      if($produto->temWaterMark()) {
          $waterMark = $produto->getWaterMark();
      }

      $taxaImpressao = "";
      if($produto->temTaxaImpressao()) {
          $taxaImpressao = $produto->getTaxaImpressao();
      }

      $tipoProduto = get_class($produto);

      $query = "insert into produto (nome, preco, descricao, categoria,
              usado, isbn, tipoProduto, waterMark, taxaImpressao)
                  values ('{$produto->getNome()}', {$produto->getPreco()},
                      '{$produto->getDescricao()}', {$produto->getCategoria()->getId()},
                          {$produto->getUsado()}, '{$isbn}', '{$tipoProduto}',
                              '{$waterMark}', '{$taxaImpressao}')";

      return mysqli_query($this->conexao, $query);
    }

    public function atualizaNoBanco(Produto $produto)
    {
      $isbn = "";
      if($produto->isLivro()) {
          $isbn = $produto->getIsbn();
      }

      $waterMark = "";
      if($produto->temWaterMark()) {
          $waterMark = $produto->getWaterMark();
      }

      $taxaImpressao = "";
      if($produto->temTaxaImpressao()) {
          $taxaImpressao = $produto->getTaxaImpressao();
      }

      $tipoProduto = get_class($produto);

      $query = "update produto set nome = '{$produto->getNome()}',
          preco = {$produto->getPreco()}, descricao = '{$produto->getDescricao()}',
              categoria= {$produto->getCategoria()->getId()},
                  usado = {$produto->getUsado()}, isbn = '{$isbn}',
                      tipoProduto = '{$tipoProduto}', waterMark = '{$waterMark}',
                          taxaImpressao = '{$taxaImpressao}' where id = '{$produto->getId()}'";

      return mysqli_query($this->conexao, $query);
    }

    public function removerDoBanco($id)
    {
        $query = "delete from produto where id = {$id}";
        error_log(print_r($query, true));
        return mysqli_query($this->conexao, $query);
    }

    public function findListProduto()
    {
        $produtoList = [];
        $query = "select produto.*, categoria.nome as categoria_nome from produto join categoria on produto.categoria = categoria.id";
        $result = mysqli_query($this->conexao, $query);
        echo mysqli_error($this->conexao);
        while ($produto_arr = mysqli_fetch_assoc($result)) {
            $tipoProduto = $produto_arr['tipoProduto'];
            $produto_id = $produto_arr['id'];
            $categoria_nome = $produto_arr['categoria_nome'];

            $factory = new ProdutoFactory();
            $produto = $factory->criaPor($tipoProduto, $produto_arr);
            $produto->atualizaBaseadoEm($produto_arr);

            $produto->setId($produto_id);
            $produto->getCategoria()->setNome($categoria_nome);

            array_push($produtoList, $produto);
        }
        return $produtoList;
    }

    public function findById($id)
    {
        $query = "select produto.*, categoria.nome as categoria_nome from produto join categoria on produto.categoria = categoria.id where produto.id = '{$id}'";
        $result = mysqli_query($this->conexao, $query);
        $produto_arr = mysqli_fetch_assoc($result);

        $tipoProduto = $produto_arr['tipoProduto'];
        $produto_id = $produto_arr['id'];
        $categoria_id = $produto_arr['categoria'];

        $factory = new ProdutoFactory();
        $produto = $factory->criaPor($tipoProduto, $produto_arr);
        $produto->atualizaBaseadoEm($produto_arr);

        $produto->setId($produto_id);
        $produto->getCategoria()->setId($categoria_id);

        return $produto;
    }
}
