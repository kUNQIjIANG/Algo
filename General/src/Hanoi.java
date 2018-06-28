/**
 * Created by kunqi on 6/28/18.
 */
public class Hanoi {
    public static void hanoiMove(int n, char from, char to, char aux){
        if (n == 1){
            System.out.println("Move disk 1 from " + from + " to " + to);
        } else {
            hanoiMove( n-1, from, aux, to);
            System.out.println("Move disk " + n + " from " + from + " to " + to);
            hanoiMove( n-1, aux, to, from);
        }
    }
    public static void main(String[] args){
        Hanoi.hanoiMove(6, 'A', 'B', 'C');
    }
}

