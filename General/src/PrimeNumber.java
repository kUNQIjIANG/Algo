/**
 * Created by kunqi
 * ON Apr/04/2019 23:41
 */
public class PrimeNumber {
    static void primeNumber(int n){
        boolean[] mark = new boolean[n+1];
        for(int i = 0; i <= n; i++) mark[i] = true;
        for (int i = 2; i*i < n; i++){
            if(!mark[i]) continue;
            for (int j = i*i; j< n; j += i){
                mark[j] = false;
            }
        }
        for (int i = 2; i<n; i++){
            if(mark[i]) System.out.println(i);
        }
    }

    public static void main(String[] args) {
        primeNumber(20);
    }
}
