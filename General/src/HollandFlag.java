/**
 * Created by kunqi
 * ON 12/21/18 10:32 PM
 */

public class HollandFlag {
    private static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static int[] hollandSort(int[] arr){
        int begin = 0;
        int cur = 0;
        int end = arr.length - 1;

        while(cur < end){
            if (arr[cur] == 0){
                swap(arr,begin,cur);
                begin++;
                cur++;
            }
            else if(arr[cur] == 1){
                cur++;
            }
            else if(arr[cur] == 2){
                swap(arr,cur,end);
                end --;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] test = {0,1,2,1,1,0,2,1,0};
        int[] sorted = hollandSort(test);
        for (int i : sorted){
            System.out.print(i);
        }

    }
}
