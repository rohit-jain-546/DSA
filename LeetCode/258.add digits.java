class Solution {
    public int addDigits(int num) {
        int sum = 0;
        do{
            while(num!=0){
            sum += num%10;
            num/=10;
        }num=sum;
        if (num<10)
        return num;
        sum = 0;
        }while(num>=10);
        return num;

    }
}