import java.util.LinkedList;

/**
 * Created by kunqi on 6/28/18.
 */
public class GetMaxWindon {
    public static int[] getMaxWindom(int[] arr, int w){
        if (arr.length < w || w < 1 || arr == null){
            return null;
        } else {
            LinkedList<Integer> maxq = new LinkedList<>();
            int[] res = new int[arr.length - w + 1];
            int index = 0;
            for ( int i = 0; i < arr.length; i++){
                while (!maxq.isEmpty() && arr[maxq.peekLast()] <= arr[i]){
                    maxq.pollLast();
                }
                maxq.addLast(i);
                if (maxq.peekFirst() == i - w){
                    maxq.pollFirst();
                }
                if ( i >= w-1 ){
                    res[index++] = arr[maxq.peekFirst()];
                }
            }
            return res;
        }

    }

    public static void main(String[] args){
        int[] intArr = {4,3,5,4,3,3,6,7};
        int[] res = GetMaxWindon.getMaxWindom(intArr, 3);
        for (int i = 0; i<res.length; i++){
            System.out.println(res[i]);
        }
    }
}
