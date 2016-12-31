<?php
session_start();
require_once("PHPMailer/class.smtp.php");
require_once('PHPMailer/PHPMailerAutoload.php');
require_once 'UsuarioRepositorio.php';

verificaUsuario();

$nome = $_POST["nome"];
$email = $_POST["email"];
$mensagem = $_POST["mensagem"];

$mail = new PHPMailer;

$mail->isSMTP();                                      // Set mailer to use SMTP
$mail->Host = 'smtp.gmail.com';                  // Specify main and backup SMTP servers
$mail->SMTPAuth = true;                               // Enable SMTP authentication
$mail->Username = 'weldermarcosxd@gmail.com';                 // SMTP username
$mail->Password = 'shuriken2011';                           // SMTP password
$mail->SMTPSecure = 'tls';                            // Enable TLS encryption, `ssl` also accepted
$mail->Port = 587;                                    // TCP port to connect to

$mail->setFrom('weldermarcosxd@gmail.com', 'Mailer');
$mail->addAddress($email, $nome);     // Add a recipient             // Name is optional
$mail->addReplyTo('weldermarcosxd@gmail.com', 'Welder Marcos');
$mail->addCC('weldermarcosxd@hotmail.com');
$mail->addBCC('weldermarcosxd@outlook.com');

$mail->addAttachment('/home/welder/Pictures/Kaneki.jpg', 'Kaneki');         // Add attachments
$mail->isHTML(true);                                  // Set email format to HTML

$mail->Subject = 'Hello';
$mail->Body    = $mensagem;
$mail->AltBody = 'This is the body in plain text for non-HTML mail clients';

if(!$mail->send()) {
  $_SESSION["danger"] = 'A mensagem não pode ser enviada: ' . $mail->ErrorInfo;
  header("Location: index.php");
} else {
  $_SESSION["success"] = "Mensagem enviada com sucesso";
  header("Location: index.php");
}
