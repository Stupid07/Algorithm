let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input.pop();
let subList;

let lists = input.map((val)=>{
	subList = val.trim().split(" ");
	subList.pop();
	return subList.map(subVal=> +subVal);
});

let counts = lists.map((val)=>{
	return val.filter((cur)=>{
		return val.includes(cur<<1);
	}).length;	
});

console.log(counts.join("\n").trim());