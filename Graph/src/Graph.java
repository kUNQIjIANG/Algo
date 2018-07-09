import java.util.LinkedList;

/**
 * Created by kunqi
 * ON 7/9/18 11:38 PM
 */

public class Graph {
    int num;
    LinkedList<Integer>[] adj;

    public Graph(int v){
        this.num = v;
        adj = new LinkedList[v];
        for (int i = 0; i<v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int s){
        this.adj[v].add(s);
    }
}
