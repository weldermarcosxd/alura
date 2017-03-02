const mysql = require('mysql');

function PagamentoDao(connection) {
  this._connection = connection;
}

PagamentoDao.prototype.persist = function (pagamento, callback) {
  var query = 'INSERT INTO pagamentos SET ?';
  this._connection.query(query, pagamento, callback);
};

PagamentoDao.prototype.updateStatus = function (pagamento, callback) {
  var query = 'UPDATE pagamentos SET status = ? where id = ?';
  this._connection.query(query, [pagamento.status, pagamento.id], callback);
};

PagamentoDao.prototype.findById = function (_id, callback) {
  var query = 'SELECT FROM pagamentos WHERE _id = ??';
  query = mysql.format(query,_id);
  this._connection.query(query, callback);
};

module.exports = function () {
  return PagamentoDao;
}
