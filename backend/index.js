const express = require('express');
const cors = require('cors');

const app = express();
const port = 8000;

app.use(express.json());
app.use(cors());

app.use('/', require('./routes'));

app.listen(port, function (err) {
  if (err) {
    console.log(`Error in running the server: ${err}`);
  }

  console.log(`Server is running on port: ${port}`);
});
