import java.util.Stack;

/**
 * Created by kunqi on 6/28/18.
 */

public class ReverseStack {

    public ReverseStack(){};
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        } else {
            int i = getAndRemoveLastElement(stack);
            reverseStack(stack);
            stack.push(i);
        }
    }
}
