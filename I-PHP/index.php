<?php include("cabecalho.php");
      include("UsuarioRepositorio.php");
?>
<?php
  if (usuarioEstaLogado() && isset($_GET["logado"]) && $_GET["logado"] == 1) {
      ?> <p class="text-success">Usuário Logado</p> <?php

  } else {
      if (!usuarioEstaLogado() && isset($_GET["logado"]) && $_GET["logado"] === 0) {
          ?> <p class="text-danger">Usuário inválido</p> <?php
      }
  }

  if (isset($_GET["falhaDeSeguranca"])) {
      ?>
      <p class="alert-danger">Você não tem acesso a esta funcionalidade!</p>
    <?php
  }

  if (isset($_GET["logout"]) && $_GET["logout"] == true) {
      ?>
      <p class="alert-warning">Logout realizado com sucesso!</p>
    <?php
  }

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
<?php include './footer.php'; ?>
