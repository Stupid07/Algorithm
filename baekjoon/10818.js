let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let N = +input[0];
let numbers = input[1].split(' ').reduce((acc,cur)=>{
	const number = +cur;
	acc[0] = acc[0] > number ? number : acc[0];
	acc[1] = acc[1] < number ? number : acc[1];
	return acc;
},[1000000,-1000000])
console.log(numbers.join(' '))