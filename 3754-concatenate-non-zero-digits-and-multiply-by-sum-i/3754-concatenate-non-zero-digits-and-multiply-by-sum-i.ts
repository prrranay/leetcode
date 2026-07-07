function sumAndMultiply(n: number): number {
    let numStr= new String(n);
    let sum=0;
    let x="";
    for(let i=0;i<numStr.length;i++){
        if(Number(numStr[i]) === 0){
            continue;
        }
        sum+=Number(numStr[i]);
        x+=numStr[i];
    }
    sum*=Number(x);
    return sum;
};