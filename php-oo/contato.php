<?php
  require_once("cabecalho.php");
  require_once 'UsuarioRepositorio.php';

  verificaUsuario();
?>

  <h2>Contato</h2>
  <form action="envia-email.php" method="post">
    <table class="table">
      <tr>
        <td>Nome:</td>
        <td><input class="form-control" type="text" name="nome"></td>
      </tr>
      <tr>
        <td>Email:</td>
        <td><input class="form-control" type="email" name="email"></td>
      </tr>
      <tr>
        <td>Mensagem:</td>
        <td><textarea class="form-control" name="mensagem"></textarea></td>
      </tr>
      <tr>
        <td colspan="2"><button class="btn btn-primary form-control" type="submit" name="button" >Enviar</button></td>
      </tr>
    </table>
  </form>


<?php
  require_once("footer.php");
 ?>
