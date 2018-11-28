/**
 * Created by kunqi
 * ON 11/28/18 9:58 PM
 */

public class ProductConsumer {
    public static void main(String[] args) {
        Drop drop = new Drop();
        String[] messages = {"Keep clam and carry on",
                             "Never vanity",
                             "Fly the mercy",
                             "persistent"};
        (new Thread(new Producer(drop,messages))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
