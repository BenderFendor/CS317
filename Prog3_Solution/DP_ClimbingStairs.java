class Solution {
    // public int climbStairs(int n) { Decrease by 1 or 2, but time limit exceeded. 
    //     if (n == 1) return 1;
    //     if (n == 2) return 2;
    //     // Decrease by constant: n reduced by 1 and 2 at each step
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }
    public int climbStairs(int n) { dynamic programming
        // Base cases
        if (n == 1) return 1;
        if (n == 2) return 2;

        int prev2 = 1;  // f(1)
        int prev1 = 2;  // f(2)

        // Decrease-by-1: build up one step at a time from smaller instances
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;  // f(i) = f(i-1) + f(i-2)
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
  
