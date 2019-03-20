import java.util.Stack;

/**
 * Created by kunqi
 * ON 3/10/19 10:26 PM
 */

//剑指offer 22题
public class PushPopSequence {
    public static boolean pushPopSequence(int[] pushSeq, int[] popSeq){
        Stack<Integer> stack = new Stack<Integer>();

        int pushLen = pushSeq.length;
        int popLen = popSeq.length;
        if (pushLen != popLen) return false;

        int pushIndex = 0, popIndex = 0;


        while(popIndex < popLen){
            if (pushIndex < pushLen && (stack.isEmpty() || stack.peek() != popSeq[popIndex])){
                stack.push(pushSeq[pushIndex++]);
            }else if (!stack.isEmpty() && stack.peek() == popSeq[popIndex]){
                stack.pop();
                popIndex++;
            }else if (pushIndex >= pushLen && stack.peek() != popSeq[popIndex]) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
        System.out.println(pushPopSequence(push,pop));
    }
}
