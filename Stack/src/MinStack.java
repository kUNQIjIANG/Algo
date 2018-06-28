import java.util.Stack;

/**
 * Created by kunqi on 6/27/18.
 */

public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;


    public MinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int x){
        stackData.push(x);
        if (this.stackMin.isEmpty()) stackMin.push(x);
        else if(this.getMin() > x){
            this.stackMin.push(x);
        }
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("Stack is empty");
        } else if(this.getMin() == this.stackData.peek()){
            this.stackMin.pop();
        }
        return this.stackData.pop();
    }

    public int getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Stack is empty");
        } else{
            return this.stackMin.peek();
        }
    }

}
