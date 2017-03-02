const app = require('./config/express.js')();
const constants = require('./constants');

app.listen(constants.PORT, () => {
  console.log('Server listening in port ' + constants.PORT);
});
