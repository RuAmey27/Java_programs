//correct file

const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');

const app = express();
const PORT = process.env.PORT || 3000;

// Connect to MongoDB
mongoose.connect('mongodb://localhost:27017/form', { useNewUrlParser: true, useUnifiedTopology: true });

// Define a schema for your data
const formEntrySchema  = new mongoose.Schema({
    name: {
        type: String,
        required: true,
      },
      email: {
        type: String,
        required: true,
      },
});

// Create a model based on the schema
const FormEntry = mongoose.model('FormEntry', formEntrySchema);

// Middleware to parse form data
app.use(bodyParser.urlencoded({ extended: true }));

// Serve the HTML form
app.get('/', (req, res) => {
    res.sendFile(__dirname + '/public/index.html');
});

// Handle form submissions
app.post('/submit', (req, res) => {
    const { name, email } = req.body;

    // Create a new Submission instance
    const newSubmission = new FormEntry({
        name,
        email
    });

    // Save the submission to the database
    // Save the submission to the database
newSubmission.save()
.then(() => {
    res.send('Form submitted successfully!');
})
.catch((err) => {
    console.error(err);
    res.send('Error submitting the form.');
});

});

// Start the server
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
