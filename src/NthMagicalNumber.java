public class NthMagicalNumber {
    //https://leetcode.com/problems/nth-magical-number/
    //A positive integer is magical if it is divisible by either a or b.
    //
    //Given the three integers n, a, and b, return the nth magical number.
    // Since the answer may be very large, return it modulo 109 + 7.

    public static int nthMagicalNumber(int n, int a, int b) {
        long lcm = lcm(a, b);
        long ans = 0;
        for (long l = 0, r = (long) n * Math.min(a, b), m = 0;  l <= r ;) {
            m = l + ((r - l) >> 1);
            if(m / a + m / b - m / lcm >= n){
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int) (ans % 1000000007);
    }

    public static long gcd(long a, long b){
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b){
        return (long) a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(1, 2, 3));
    }
}
