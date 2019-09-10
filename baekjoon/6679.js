let diff = [10, 12, 16];
for(let i = 2992; i < 10000; i++){
	if(diff.map((value)=>Number(i).toString(value).split("").reduce((acc,cur)=>acc+parseInt(cur, value),0))
	.every((cur, idx, array)=>cur == array[0])){
		console.log(i);
	}
}