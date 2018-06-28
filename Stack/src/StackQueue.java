import java.util.Stack;

/**
 * Created by kunqi on 6/27/18.
 */
public class StackQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public StackQueue(){
        this.pushStack = new Stack<Integer>();
        this.popStack = new Stack<Integer>();
    }

    public void add(int x){
        this.pushStack.push(x);
    }

    public int poll(){
        if(this.popStack.isEmpty() && this.pushStack.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else if(this.popStack.isEmpty()){
            while(!this.pushStack.isEmpty()){
                this.popStack.push(this.pushStack.pop());
            }
        }
        return this.popStack.pop();
    }
}
