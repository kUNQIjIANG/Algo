/**
 * Created by kunqi
 * ON Mar/23/2019 20:26
 */

// 找出数组中的逆序对数
public class InversePairs {
    static int inversePairs(int[] arrs){
        if (arrs == null) return 0;
        int[] copy = new int[arrs.length];
        for (int i = 0; i < arrs.length; i++) copy[i] = arrs[i];
        int res = inversePairsNum(arrs,copy,0,arrs.length-1);
        return res;
    }


    static int inversePairsNum(int[] arrs, int[] copy, int start, int end){

        // base case important !!!
        if (start == end){
            copy[start] = arrs[start];
            return 0;
        }
        int mid = (start + end) / 2;
        // 左右半边子数组的逆序对数
        // 进行排序的是arrs,所以后面用的是arrs来比较 ！！！！
        int leftInversePairs = inversePairsNum(copy,arrs,start,mid);
        int rightInversePairs = inversePairsNum(copy,arrs,mid+1,end);
        // 指向左右子数组的最后一位(已排好序）
        int count = 0;
        int i = mid;
        int j = end;
        int indexCopy = end;
        while( i >= start && j >= mid+1){
            if (arrs[i] > arrs[j]){
                copy[indexCopy--] = arrs[i--];
                count += (j-mid);
            }else{
                copy[indexCopy--] = arrs[j--];
            }
        }
        for (; i >= start; i--){
            copy[indexCopy--] = arrs[i];
        }
        for (; j >= mid+1; j--){
            copy[indexCopy--] = arrs[j];
        }
        return leftInversePairs + rightInversePairs + count;
    }

    public static void main(String[] args) {
        int[] arrs = {7,5,6,4};
        System.out.println(inversePairs(arrs));
    }
}
