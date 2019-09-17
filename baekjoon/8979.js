let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let K = +input.shift().split(" ").pop();
let parseArray = value => value.split(" ").map(v => +v);
let base = parseArray(input.find(value => +value.split(" ")[0] == K));

let compare = (flag, value, idx) =>{
	if(flag != 0 || idx < 1) return flag;
	else return value - base[idx]; 
};
let reducer = (acc, cur)=>{
	if(parseArray(cur).reduce(compare, 0) > 0){
		acc++;
	}
	return acc;
};
let result = input.reduce(reducer, 1);

console.log(result);