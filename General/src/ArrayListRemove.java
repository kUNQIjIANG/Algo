import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kunqi
 * ON Mar/28/2019 11:02
 */
public class ArrayListRemove {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(5);
        List<String> arr = Arrays.asList("a","b");
        array.add(1);
        array.add(2);
        array.add(2);
        array.add(4);
        array.add(5);
        int size = array.size();
        for (int i = 0; i < array.size(); i++){
            System.out.println(array.get(0));
            array.remove(0);
        }
        System.out.println(array.toString());
    }

}
