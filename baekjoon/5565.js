let fs = require('fs');
let inputs = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
console.log(inputs.map(value=>+value).reduce((acc,cur)=>acc-cur));