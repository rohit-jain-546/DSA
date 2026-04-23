class Solution {
    public boolean isHappy(int n) {
         int sum = 0;
         HashSet<Integer> set = new HashSet<>();
        while(n!=1&&!set.contains(n)){
            set.add(n);
            while(n!=0){
            sum += n%10*(n%10);
            n/=10;
        }
        n=sum;
        sum = 0;
        }
        return n==1;
    }
}