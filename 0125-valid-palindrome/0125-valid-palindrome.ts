function isPalindrome(s: string): boolean {
    s=s.toLowerCase().replace(/[^a-zA-Z0-9]/g, '');
    let r=s.split('').reverse().join('');
    return s === r;
};