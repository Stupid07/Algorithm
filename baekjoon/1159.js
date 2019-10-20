let fs = require('fs');
let inputs = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
inputs.shift();

let resultArray = new Array(26);
let initIdx = 26;
while(initIdx--){
    resultArray[initIdx] = 0;
}

let result = inputs.reduce((acc,cur)=>{
    acc[cur.charCodeAt(0)-97]++;
    return acc;
}, resultArray);

let answer = result.reduce((acc, cur, idx)=>{
    if(cur >= 5){
        acc += String.fromCharCode(97+idx)
    }
    return acc;
}, '');

if(answer == ''){
    answer = 'PREDAJA';
}

console.log(answer);