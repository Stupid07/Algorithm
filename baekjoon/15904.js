let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();
let isUCPC = /.*U.*C.*P.*C.*/;
console.log(`I ${isUCPC.test(input)?'love':'hate'} UCPC`);