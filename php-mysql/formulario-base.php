  <tr>
      <td>Nome:</td>
      <td><input type="text" class="form-group" name="nome" value="<?=$produto['nome'] ?>"></td>
  </tr>
  <tr>
      <td>Preco:</td>
      <td><input type="number" class="form-group" name="preco" value="<?=$produto['preco'] ?>"></td>
  </tr>
  <tr>
      <td></td>
      <td><input type="checkbox" class="form-group" name="usado" value="true" checked="<?=$produto['usado'] ?>"> Usado</td>
  </tr>
  <tr>
      <td>Categoria:</td>
      <td>
          <select name="categoria" class="form-group">
  <?php
      foreach ($categoriaList as $categoria) {
        $essaEhACategoria = $produto['categoria'] == $categoria['id'];
        $selecao = $essaEhACategoria ? "selected='selected'" : "";
          ?>
          <option value="<?=$categoria['id'] ?>" <?=$selecao ?>><?=$categoria['nome'] ?></option>
  <?php

      }
  ?>
          </select>
      </td>
  </tr>
  <tr class="form-group">
      <td>Descrição:</td>
      <td><textarea name="descricao" rows="3" class="form-control"><?=$produto['descricao'] ?></textarea></td>
  </tr>
