let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input.reduce((acc,cur)=>{
	if((+cur[cur.length-1])&1 == 1){
		console.log('odd');
	}else{
		console.log('even');
	}
});