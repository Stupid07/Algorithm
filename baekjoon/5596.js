let fs = require('fs');
let inputs = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let result = inputs.map((value)=>value.split(" ").reduce((acc, cur)=> acc +(+cur), 0));
console.log(Math.max(...result));