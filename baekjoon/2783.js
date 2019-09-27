let fs = require('fs');
let inputs = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
inputs.splice(1,1);
let prices = inputs.map(value=>value.split(' ').map(v=>+v).reduce((acc,cur)=>acc/cur));
let price = prices.reduce((acc, cur)=>acc< cur ? acc : cur);
console.log((price * 1000.0).toFixed(2));