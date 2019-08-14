let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const division = 42;
let result = input.reduce((acc,cur)=>{
	acc.add(cur%division);
	return acc;
},new Set());
console.log(result.size);