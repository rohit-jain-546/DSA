class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] cnt=new int[26];

        for(char c:s.toCharArray())
            cnt[c-'a']++;

        int mid=-1;

        for(int i=0;i<26;i++){
            if(cnt[i]%2!=0){
                if(mid!=-1)
                    return "";
                mid=i;
                cnt[i]--;
            }
        }

        int n=s.length();
        int half=n/2;

        for(int i=0;i<half;i++)
            cnt[target.charAt(i)-'a']-=2;

        if(valid(cnt)){
            String left=target.substring(0,half);
            String right=new StringBuilder(left).reverse().toString();
            String ans=left+(mid==-1?"":(char)('a'+mid))+right;

            if(ans.compareTo(target)>0)
                return ans;
        }

        for(int i=half-1;i>=0;i--){
            int x=target.charAt(i)-'a';
            cnt[x]+=2;

            if(!valid(cnt))
                continue;

            for(int j=x+1;j<26;j++){
                if(cnt[j]>=2){
                    cnt[j]-=2;

                    StringBuilder left=new StringBuilder(target.substring(0,i));
                    left.append((char)('a'+j));

                    for(int k=0;k<26;k++){
                        while(cnt[k]>=2){
                            left.append((char)('a'+k));
                            cnt[k]-=2;
                        }
                    }

                    String l=left.toString();
                    String r=new StringBuilder(l).reverse().toString();

                    return l+(mid==-1?"":(char)('a'+mid))+r;
                }
            }
        }

        return "";
    }

    private boolean valid(int[] cnt){
        for(int x:cnt){
            if(x<0)
                return false;
        }
        return true;
    }
}