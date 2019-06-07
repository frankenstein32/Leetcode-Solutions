import java.util.*;

public class StockSpanner {

	Stack<Integer> prices, weights;
    public StockSpanner() {
     		
    	this.prices = new Stack<>();
    	this.weights = new Stack<>();
    }
    
    public int next(int price) {
        		
    	int w = 1;

    	while(!prices.isEmpty() && prices.peek() <= price){
    		this.prices.pop();
    		w += this.weights.pop();
    	}

    	this.prices.push(price);
    	this.weights.push(w);

    	return w;
    }	

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */