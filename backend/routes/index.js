const express = require('express');
const fs = require('fs');

const router = express.Router();

router.get('/ping', function (req, res) {
  return res.status(200).json({
    message: 'Pong',
  });
});

router.post('/create', function (req, res) {
  const { name, description, team_members } = req.body;
  console.log(req.body);

  var data = {
    name: name,
    description: description,
    team_members: team_members,
  };

  var dataToStore = JSON.stringify(data);

  fs.writeFile('./test.json', dataToStore, function (err) {
    if (err) {
      console.log('There has been an error saving data');
      console.log(err.message);
      return res.status(404).json({
        message: 'Something went wrong while saving data!',
      });
    }
    console.log('Successfully saved data');
  });

  return res.status(200).json({
    message: 'Successfully saved data',
  });
});

module.exports = router;
