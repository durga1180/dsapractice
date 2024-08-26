package org.example.scaler.maths;

/**
 * Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
 * "^" means power,
 * "%" means mod, and
 * "!" means factorial.
 * Note: Ensure to handle integer overflow when performing the calculations.
 * Problem Constraints
 * 1 <= A, B <= 5e5
 */
public class VeryLargePower {
    public static void main(String[] args) {
        int res = solve(2,27);
        System.out.println(res);
    }

    /**
     * Fermat little theorem
     * @return
     * Fermat's little theorem states that if p is a prime number, then for any integer a, the number a p – a is an
     * integer multiple of p. ap ≡ a (mod p). Special Case: If a is not divisible by p, Fermat's little theorem is
     * equivalent to the statement that a p-1-1 is an integer multiple of p
     */
    private static int solve(int A, int B) {
        long mod=1000000007;

        /*
        reason I use (mod - 1) in the factorial calculation rather than using mod directly has to do with properties from number theory,
        specifically related to modular exponentiation and Euler's theorem.
         */
        long fact=1;
        for( long i=2; i<=B;i++){
            fact=(fact*i)%(mod-1);
        }
        return (int)fastPow(A,fact,mod);
    }

    public static long fastPowRec( long A, long p, long mod){
        if(p==0)
            return 1;
        System.out.println("P:::"+p);
        long half=fastPow(A,p/2,mod)%mod;
        System.out.println("half::"+half);

        if(p%2==0){
            System.out.println("Not a prime");
            return (half*half)%mod;
        }

        else{
            System.out.println("Is a prime");
            return (((A*half)%mod)*half)%mod;
        }

    }
    public static long fastPow(long A, long p, long mod) {
        long result = 1;
        long base = A % mod;

        while (p > 0) {
            // If p is odd, multiply the base with the result
            if (p % 2 == 1) {
                result = (result * base) % mod;
            }
            // Square the base
            base = (base * base) % mod;
            // Divide p by 2
            p = p / 2;
        }

        return result;
    }


}
