let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input.pop();

const reducer = (acc,cur)=>+cur+acc;
const result = input.map((value)=>{
	let subResult = value.split('').reduce(reducer,0);
	while(subResult > 9){
		subResult = String(subResult).split('').reduce(reducer, 0);
	}
	return subResult;
});
console.log(result.join("\n"));
