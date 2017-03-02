const soap = require('soap');
const constants = require('../constants.js');

function CorreiosClient() {
    this._url = constants.CORRIOS_URL
}

CorreiosClient.prototype.calculaPrazo = function(dados, callback) {
  soap.createClient(this._url, (err, client) => {
    if(err){
      console.log("Erro na comunicação com o servidor dos correios: " + err);
      return;
    }else{
      client.CalcPrazo(dados, callback)
    }
  })
};

module.exports = function() {
    return CorreiosClient;
}
