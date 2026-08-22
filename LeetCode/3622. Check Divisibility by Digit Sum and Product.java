class Solution {
    public boolean checkDivisibility(int n) {
        int x = n;
        int sum = 0;
        int product = 1;
        while (x > 0) {
            int d = x % 10;
            sum += d;
            product *= d;
            x = x / 10;
        }
        int value = sum + product;
        return n % value == 0;
    }
}