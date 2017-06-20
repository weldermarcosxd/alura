const {
  app,
  BrowserWindow
} = require('electron');

let mainWindow = null;
app.on('ready', () => {
  console.log("running");
  mainWindow = new BrowserWindow({
    width: 800,
    height: 600
  });
  mainWindow.loadURL(`file://${__dirname}/app/index.html`);
})

app.on('window-all-closed', () => {
      app.quit();
 });
