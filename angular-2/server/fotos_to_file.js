var mysql = require('mysql');

// http://nodejs.org/docs/v0.6.5/api/fs.html#fs.writeFile
var fs = require('fs');

var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'celulalagoa'
});

connection.connect();

connection.query(
  "select pessoa.id as 'pessoa_id', pessoa.nome as 'pessoa_nome', foto.id as 'foto_id',  " +
  " foto.nome as 'foto_nome', foto.tipo as 'foto_tipo', " +
  " foto_conteudo.conteudo_binario as 'foto_binario' " +
  " from pessoa " +
  " inner join foto on pessoa.foto = foto.id " +
  " inner join foto_conteudo on foto.binary_content = foto_conteudo.id;",
    function(err, results, fields) {
        if (err) throw err;

        results.forEach(function (foto) {

          if(foto.foto_nome.substring(0,8) == "migracao"){
            foto.foto_nome = foto.foto_nome + ".jpg";
            console.log(foto.foto_nome.substring(0,8));
          }

          fs.writeFile("temp/" + foto.foto_nome, foto.foto_binario, function(err) {});
        })

        connection.end();
    });
