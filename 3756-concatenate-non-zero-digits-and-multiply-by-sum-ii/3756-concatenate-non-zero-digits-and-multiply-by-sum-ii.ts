function sumAndMultiply(s: string, queries: number[][]): number[] {
    const MOD = 1000000007n;
    const n = s.length;

    const sumPrefix = new Array<number>(n + 1).fill(0);
    const cnt = new Array<number>(n + 1).fill(0);

    const pref = new Array<bigint>(n + 1).fill(0n);
    const pow10 = new Array<bigint>(n + 1).fill(0n);

    pow10[0] = 1n;

    for (let i = 0; i < n; i++) {
        const d = Number(s[i]);

        sumPrefix[i + 1] = sumPrefix[i] + d;
        cnt[i + 1] = cnt[i] + (d !== 0 ? 1 : 0);

        if (d !== 0) {
            pref[i + 1] = (pref[i] * 10n + BigInt(d)) % MOD;
        } else {
            pref[i + 1] = pref[i];
        }

        pow10[i + 1] = (pow10[i] * 10n) % MOD;
    }

    const ans: number[] = [];

    for (const [l, r] of queries) {
        const sum = sumPrefix[r + 1] - sumPrefix[l];
        const k = cnt[r + 1] - cnt[l];

        let x =
            (pref[r + 1] -
                (pref[l] * pow10[k]) % MOD +
                MOD) %
            MOD;

        ans.push(Number((x * BigInt(sum)) % MOD));
    }

    return ans;
}