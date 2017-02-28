var fs = require('fs');
var obj;
fs.readFile('table.json', 'utf8', function (err, data) {
  if (err) throw err;
  obj = JSON.parse(data);

  var associados = [];

  obj.forEach(function(associado) {

    if(associados.length == 1){
      console.log(associados[associados.length - 1].id);
      console.log(associado.titular_id);
    }

    if(associados.length < 1 || associados[associados.length - 1].id != associado.titular_id){
      var asso = {
        id: associado.titular_id,
        nome: associado.titular_nome,
        data_nascimento: associado.titular_dob,
        categoria: associado.titular_categoria,
        situacao: associado.titular_situacao,
        foto: null != associado.titular_foto && associado.titular_foto.substring(0,8) == "migracao" ? associado.titular_foto + '.jpg' : associado.titular_foto,
        dependentes: [{
            id:associado.dependente_id,
            nome: associado.dependente_nome,
            data_nascimento: associado.dependente_dob,
            categoria: associado.dependente_categoria,
            situacao: associado.dependente_situacao,
            foto: null != associado.dependente_foto && associado.dependente_foto.substring(0,8) == "migracao" ? associado.dependente_foto + '.jpg' : associado.dependente_foto
        }]
      }
      associados.push(asso);
    }else{
      associados[associados.length - 1].dependentes.push({
        id:associado.dependente_id,
        nome: associado.dependente_nome,
        data_nascimento: associado.dependente_dob,
        categoria: associado.dependente_categoria,
        situacao: associado.dependente_situacao,
        foto: associado.dependente_foto && associado.dependente_foto.substring(0,8) == "migracao" ? associado.dependente_foto + '.jpg' : associado.dependente_foto
      })
    }
  });

  fs.writeFile('table2.json', JSON.stringify(associados), function(err) {
      if (err) throw err;
      console.log('Saved!');
  });

});
