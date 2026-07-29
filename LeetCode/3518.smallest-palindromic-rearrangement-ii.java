class Solution{
    static final long LIM=1000000L;

    public String smallestPalindrome(String s,int k){
        int[]cnt=new int[26];
        for(char c:s.toCharArray())cnt[c-'a']++;
        int[]half=new int[26];
        String mid="";
        int len=0;
        for(int i=0;i<26;i++){
            half[i]=cnt[i]/2;
            len+=half[i];
            if((cnt[i]&1)==1)mid=String.valueOf((char)('a'+i));
        }
        if(countWays(half)<k)return "";
        StringBuilder left=new StringBuilder();
        for(int pos=0;pos<len;pos++){
            for(int c=0;c<26;c++){
                if(half[c]==0)continue;
                half[c]--;
                long ways=countWays(half);
                if(ways>=k){
                    left.append((char)('a'+c));
                    break;
                }
                k-=ways;
                half[c]++;
            }
        }
        StringBuilder ans=new StringBuilder(left);
        ans.append(mid);
        ans.append(new StringBuilder(left).reverse());
        return ans.toString();
    }

    long countWays(int[]half){
        long res=1;
        int used=0;
        for(int x:half){
            if(x==0)continue;
            res=mulCap(res,combCap(used+x,x));
            if(res>=LIM)return LIM;
            used+=x;
        }
        return res;
    }

    long mulCap(long a,long b){
        if(a>=LIM||b>=LIM)return LIM;
        if(a> LIM/b)return LIM;
        long v=a*b;
        return Math.min(v,LIM);
    }

    long combCap(int n,int r){
        r=Math.min(r,n-r);
        long res=1;
        for(int i=1;i<=r;i++){
            long num=n-r+i;
            long den=i;
            long g=gcd(num,den);
            num/=g;
            den/=g;
            g=gcd(res,den);
            res/=g;
            den/=g;
            if(res>LIM/num)return LIM;
            res*=num;
            res/=den;
            if(res>=LIM)return LIM;
        }
        return res;
    }

    long gcd(long a,long b){
        while(b!=0){
            long t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
}