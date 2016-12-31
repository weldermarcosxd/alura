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
        if(null != $produto->getCategoria()){
          $essaEhACategoria = $produto->getCategoria()->getId() == $categoria->getId();
        }
        $selecao = $essaEhACategoria ? "selected='selected'" : "";
          ?>
          <option value="<?=$categoria->getId() ?>" <?=$selecao ?>><?=$categoria->getNome() ?></option>
  <?php

      }
  ?>
          </select>
      </td>
  </tr>
  <tr class="form-group">
      <td>Descrição:</td>
      <td><textarea name="descricao" rows="3" class="form-control"><?=$produto->getDescricao() ?></textarea></td>
  </tr>
