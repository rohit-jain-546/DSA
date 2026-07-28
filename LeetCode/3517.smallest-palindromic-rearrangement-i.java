class Solution {
    public String smallestPalindrome(String s) {
        int[] count=new int[26];

        for(char c:s.toCharArray()) count[c-'a']++;

        StringBuilder left=new StringBuilder();
        char mid=0;

        for(int i=0;i<26;i++){
            if((count[i]&1)==1) mid=(char)('a'+i);

            while(count[i]>1){
                left.append((char)('a'+i));
                count[i]-=2;
            }
        }

        StringBuilder ans=new StringBuilder();
        ans.append(left);

        if(mid!=0) ans.append(mid);

        ans.append(new StringBuilder(left).reverse());
        return ans.toString();
    }
}