let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let N = parseInt(input.shift());
let costArray = new Array(N+1).fill(0);
let nextIdx, nextSum;
let result = input.map(v=>v.split(' ').map(n=>parseInt(n))).reduce(
    (prev, cur, idx)=>{
        prev[idx] = prev[idx] < prev[idx-1] ? prev[idx-1] : prev[idx];
        nextIdx = cur[0]+idx;
        nextSum = prev[idx] + cur[1];
        if(nextIdx <= N && prev[nextIdx] < nextSum){
            prev[nextIdx] = nextSum;
        }
        return prev;
    }
,costArray).reduce((pre, cur)=>pre<cur?cur:pre);

console.log(result);