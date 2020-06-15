let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let result = input[1].split(' ').sort((a,b)=>b-a).reduce((acc,cur,idx)=>acc + (idx+1)*cur, 0);

console.log(result);