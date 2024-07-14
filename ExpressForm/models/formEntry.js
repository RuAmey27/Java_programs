// models/formEntry.js

const mongoose = require('mongoose');

const formEntrySchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
  },
  email: {
    type: String,
    required: true,
  },
  // Add other fields as needed
});

const FormEntry = mongoose.model('FormEntry', formEntrySchema);

module.exports = FormEntry;