class Solution {
    static int[] nse (int [] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            result[i]=stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return result;
    }
    static int[] pse (int [] arr){
      int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n - 1; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            result[i]=stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }
        return result;  
    }
    public int largestRectangleArea(int[] heights) {
        int [] nse=nse(heights);
        int [] pse= pse(heights);
        int max=0;
        for(int i =0; i< heights.length;i++){
            int wid= nse[i]-pse[i]-1;
            int area=heights[i]*wid;
            max= Math.max(max,area);
        }return max;
    }
}