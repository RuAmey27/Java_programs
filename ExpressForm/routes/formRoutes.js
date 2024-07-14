const express = require('express');
const bodyParser = require('body-parser'); // Example body-parser middleware
const FormEntry = require('../models/formEntry');
const router = express.Router();

router.use(express.json()); // Use body-parser middleware
router.post('/api/submit-form', async (req, res) => {
  try {
    const { name, email } = req.body;

    // Validate and save the form entry
    const formEntry = new FormEntry({ name, email });
    await formEntry.save();

    res.status(201).json({ message: 'Form submitted successfully' });
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

module.exports = router;
