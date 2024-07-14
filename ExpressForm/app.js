const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');

const app = express();
app.use(express.static('public'));
const PORT = process.env.PORT || 3000;

// Middleware
app.use(bodyParser.json());

// Routes and MongoDB connection will go here

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});

mongoose.connect('mongodb://localhost:27017/form/', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

const db = mongoose.connection;

db.on('error', console.error.bind(console, 'MongoDB connection error:'));

const formRoutes = require('./routes/formRoutes');

// ...

app.use('/api', formRoutes);
