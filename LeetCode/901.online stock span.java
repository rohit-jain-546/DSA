class StockSpanner {
    Stack<pair> stack;

    public StockSpanner() {
         stack = new Stack<>();
    }
    
    public int next(int price) {
        int sp =1;
        while(!stack.isEmpty()&&stack.peek().price<=price){
            sp+=stack.pop().span;
        }
        stack.push(new pair(price,sp));
        return sp;
    }
}
class pair{
    int price;
    int span;
    pair(int v , int s){
        price=v;
        span =s;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */