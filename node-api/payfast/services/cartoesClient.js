const restify = require('restify');
const fs = require('fs');
const constants = require('../constants.js');

function CartoesClient() {
    this._client = restify.createJsonClient({
        url: constants.CARD_URL
    });
}

CartoesClient.prototype.autoriza = function(card, callback) {
    this._client.post("/cartoes/autoriza", card, callback);
};

CartoesClient.prototype.autorizado = function(callback) {
    var card = JSON.parse(fs.readFileSync('./mock/card.json', 'utf8'));
    this._client.post("/cartoes/autoriza", card, callback);
};

module.exports = function() {
    return CartoesClient;
}
