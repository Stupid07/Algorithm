let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input.shift();

let result = input
.map((numbers)=>numbers.split(' ').map(number=>+number))
.sort((a,b)=>a[1]==b[1]?a[0]-b[0]:a[1]-b[1])
.map(v=>v.join(' '))
.join('\n');

console.log(result);