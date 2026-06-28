/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {
    if(n<2) return n;
    let arr=Array(n+1).fill(-1);
    arr[0]=0;
    arr[1]=1;
    return solve(n,arr);
};

function solve(n,arr){
    if(arr[n] == -1){
        arr[n]=solve(n-1,arr)+solve(n-2,arr);
    }
    return arr[n];
}