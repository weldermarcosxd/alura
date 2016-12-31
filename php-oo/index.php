<?php require_once("cabecalho.php");
      require_once 'model/UsuarioRepositorio.php';
?>
  <h1>Bem vindo!</h1><br>
  <?php if (usuarioEstaLogado()) {
     ?>
    <p class="text-primary">Você está logado como <?=usuarioLogado()?></p>
    <a href="logout.php">Deslogar</a></p>
  <?php

 } else {
     ?>
    <h2>Login</h2>
    <form action="login.php" method="post">
      <table class="table table-striped">
        <tr>
          <td>Email:</td>
          <td><input class="form-control" type="email" name="email"></td>
        </tr>
        <tr>
          <td>Senha:</td>
          <td><input class="form-control" type="password" name="pass"></td>
        </tr>
        <tr>
          <td colspan="2"><button class="btn btn-primary form-control">Login</button></td>
        </tr>
      </table>
    </form>
  <?php

 } ?>
<?php require_once './footer.php'; ?>
