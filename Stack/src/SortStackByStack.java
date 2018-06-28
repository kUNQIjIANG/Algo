import java.util.Stack;

/**
 * Created by kunqi on 6/28/18.
 */

// if cur > helping stack peek, poll every element that
// smaller than cur out to stack, put cur in then pull them back in

public class SortStackByStack {
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> helpStack = new Stack<Integer>();

        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!helpStack.isEmpty() && cur > helpStack.peek()){
                stack.push(helpStack.pop());
            }
            helpStack.push(cur);
        }

        while (!helpStack.isEmpty()){
            stack.push(helpStack.pop());
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(7);
        SortStackByStack.sortStackByStack(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}
