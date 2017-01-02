  <tr>
      <td>Nome:</td>
      <td><input type="text" class="form-group" name="nome" value="<?=$produto->getNome() ?>"></td>
  </tr>
  <tr>
      <td>Preco:</td>
      <td><input type="number" class="form-group" name="preco" value="<?=$produto->getPreco() ?>"></td>
  </tr>
  <tr>
      <td></td>
      <td><input type="checkbox" class="form-group" name="usado" <?=$produto->getUsado() == 1 ? 'checked' : ''?>> Usado</td>
  </tr>
  <tr>
      <td>Categoria:</td>
      <td>
          <select name="categoria" class="form-group">
        <?php
        foreach ($categoriaList as $categoria) {
            if (null != $produto->getCategoria()) {
                $essaEhACategoria = $produto->getCategoria()->getId() == $categoria->getId();
            }
            $selecao = $essaEhACategoria ? "selected='selected'" : ""; ?>
          <option value="<?=$categoria->getId() ?>" <?=$selecao ?>><?=$categoria->getNome() ?></option>
        <?php

        }
        ?>
          </select>
      </td>
  </tr>
  <tr>
    <td>Tipo do produto</td>
    <td>
      <select name="tipoProduto" class="form-control">
          <optgroup label="Livros">
              <?php
              $tipos = array("Livro Fisico", "Ebook");
              foreach($tipos as $tipo) :
                  $tipoSemEspaco = str_replace(' ', '', $tipo);
                  $esseEhOTipo = get_class($produto) == $tipoSemEspaco;
                  $selecaoTipo = $esseEhOTipo ? "selected='selected'" : "";
              ?>
                  <option value="<?=$tipoSemEspaco?>" <?=$selecaoTipo?>>
                      <?=$tipo?>
                  </option>
              <?php
              endforeach
              ?>
          </optgroup>
      </select>
    </td>
  </tr>
  <tr>
    <td>ISBN</td>
    <td>
      <input type="text" name="isbn" class="form-control"
           value="<?php if ($produto->isLivro()) {
                echo $produto->getIsbn();
            } ?>" >
    </td>
  </tr>
  <tr>
    <td>WaterMark (caso seja um Ebook)</td>
    <td>
        <input type="text" class="form-control" name="waterMark"
            value="<?php if ($produto->temWaterMark()) {
                echo $produto->getWaterMark();
            } ?>" />
    </td>
  </tr>
  <tr>
      <td>Taxa de Impressão (caso seja um Livro Físico)</td>
      <td>
          <input type="text" class="form-control" name="taxaImpressao"
              value="<?php if ($produto->temTaxaImpressao()) {
                  echo $produto->getTaxaImpressao();
              } ?>" />
      </td>
  </tr>
  <tr class="form-group">
      <td>Descrição:</td>
      <td><textarea name="descricao" rows="3" class="form-control"><?=$produto->getDescricao() ?></textarea></td>
  </tr>
