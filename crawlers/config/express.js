const express = require("express");
const consign = require("consign");

var app = express();

consign()
    .include("services")
    .into(app)

module.exports = app;