let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');
let piece = [1, 1, 2, 2, 2, 8]
console.log(input.map((cur, idx)=>piece[idx]-cur).join(' '))