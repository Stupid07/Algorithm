let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let myStack = [input.shift().trim().split(''), new Array()]
input.shift();
let result = input.reduce((prevStack, cur)=>{
    switch(cur[0]){
        case 'L': if(prevStack[0].length > 0) prevStack[1].push(prevStack[0].pop()); break;
        case 'D': if(prevStack[1].length > 0) prevStack[0].push(prevStack[1].pop()); break;
        case 'B': prevStack[0].pop(); break;
        case 'P': prevStack[0].push(cur[2]); break;
    }
    return prevStack;
}, myStack);

console.log(result[0].join('')+result[1].reverse().join(''));