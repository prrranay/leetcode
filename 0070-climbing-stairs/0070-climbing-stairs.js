/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    let arr=Array(n+1).fill(-1);
    arr[1]=1;
    arr[2]=2;
    arr[3]=3;
    return solve(n,arr)
};

function solve(n,arr){
    if(arr[n]==-1){
        arr[n]=solve(n-1,arr)+solve(n-2,arr);
    }
    return arr[n];
}