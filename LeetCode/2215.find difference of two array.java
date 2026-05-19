class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer>s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();

        for(int n:nums1)s1.add(n);
        for(int n:nums2) s2.add(n);

        List<Integer>a=new ArrayList<>();
        List<Integer>b=new ArrayList<>();

        for(int x:s1){
            if(!s2.contains(x))a.add(x);
        }

        for(int x:s2){
            if(!s1.contains(x)) b.add(x);
        }

        return Arrays.asList(a,b);
    }
}