let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let numberA = +input[0]
let numberStringB = input[1]
console.log(numberA * (+numberStringB[2]))
console.log(numberA * (+numberStringB[1]))
console.log(numberA * (+numberStringB[0]))
console.log(numberA * +numberStringB)