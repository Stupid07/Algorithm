let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let result = input.reduce((acc,cur,idx)=>{
	if(acc[0] < cur){
		acc[0] = cur;
		acc[1] = idx+1;
	}
	return acc;
},[+input[0],1]);
console.log(result.join('\n'));