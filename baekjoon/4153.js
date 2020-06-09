let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input.pop();
let resultWords = (x)=>{return x?"right":"wrong"};
let numbers;
let result = input.map((cur)=>{
    numbers = cur.split(' ').map(v=>parseInt(v)).map(v=>v*v).sort((a,b)=>a-b);
    return resultWords((numbers[0] + numbers[1]) == numbers[2]);
}).join('\n')

console.log(result)