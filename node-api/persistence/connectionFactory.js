const mysql = require('mysql');
const constants = require('../constants');

function createDBConnection() {
  return mysql.createConnection({
    host: constants.DB_HOST,
    user: constants.DB_USER,
    password: constants.DB_PASS,
    database: constants.DB_DATABASE
  })
}

module.exports = function () {
  return createDBConnection;
}
