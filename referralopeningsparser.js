//npm install node-fetch
//import fetch from "node-fetch"; 
const fetch = require("node-fetch");

var data="";

fetch("myText.txt")
  .then((res) => res.text())
  .then((text) => {
    // do something with "text"
   })
  .catch((e) => console.error(e));

console.log(text);