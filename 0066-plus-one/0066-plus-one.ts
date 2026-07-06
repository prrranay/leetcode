function plusOne(digits: number[]): number[] {
        let n=digits.length-1;
        while(digits[n] == 9 && n >= 0){
            digits[n]=0;
            n--;
        }
        if(n == -1){
            digits.unshift(1);
        }else{
            digits[n]=digits[n]+1;
        }
    return digits;
};