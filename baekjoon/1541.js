let fs = require('fs');
let inputs = fs.readFileSync('/dev/stdin').toString().split('-');
const reducer = (acc,cur)=> acc+(+cur)

const result = inputs.reduce((acc,cur)=> {
	acc -= cur.split('+').reduce(reducer,0)
	return acc	
},(inputs[0].split('+').reduce(reducer,0))<<1)

console.log(result)