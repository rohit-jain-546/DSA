class Solution {
    public int totalWaviness(int num1, int num2) {
        int count =0;
        for (int i = num1 ; i<= num2 ; i++){
            String no = i+"";
            for(int j =1 ; j< no.length()-1;j++){
                if(no.charAt(j)>no.charAt(j-1)&&no.charAt(j)>no.charAt(j+1))count++;
                if(no.charAt(j)<no.charAt(j-1)&&no.charAt(j)<no.charAt(j+1))count++;
            }
        }return count;
    }
}