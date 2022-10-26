package com.milkyway.gbusiness.models


data class AutoLoginWhmcsResponse(
    val `data`: String, // https://client.gbusiness.co/dologin.php?email=bij@gmail.com&timestamp=1645615886&hash=175faf82244d780b0d6ed87fecda3e4f2453bb3b&goto=index.php
    val message: String, // Thanks for signing ! You have  successfully
    val success: Boolean // true
)