let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input.shift();

let result = input.sort(
(a, b)=>{
    if(a.length != b.length){
        return a.length - b.length;
    }else{
        return a.localeCompare(b);
    }
}).filter((val, idx, arr)=>arr[idx-1] != val).join('\n');

console.log(result);