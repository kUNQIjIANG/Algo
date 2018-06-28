import java.util.Stack;

/**
 * Created by kunqi on 6/27/18.
 */
public class Test {
    public static void main(String[] args){

        System.out.println("MinStack-------");
        MinStack minStack = new MinStack();
        minStack.push(6);
        minStack.push(2);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());

        System.out.println("StackQueue--------");
        StackQueue stackQueue = new StackQueue();
        stackQueue.add(5);
        stackQueue.add(6);
        System.out.println(stackQueue.poll());
        System.out.println(stackQueue.poll());


        System.out.println("ReverseStack-------");
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        ReverseStack.reverseStack(stack);
        while( !stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
