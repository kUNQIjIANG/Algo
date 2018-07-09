/**
 * Created by kunqi
 * ON 7/9/18 10:54 PM
 */


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static void bfs(int n, Graph G){

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[G.num];
        q.add(n);
        visited[n] = true;
        while (!q.isEmpty()){
            n = q.remove();
            System.out.print(n+"->");
            Iterator<Integer> c = G.adj[n].listIterator();
            while(c.hasNext()){
                int s = c.next();
                if(!visited[s]){
                    visited[s] = true;
                    q.add(s);
                }
            }
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        System.out.println("Starting from vertex 2");
        BFS.bfs(2,g);
    }
}
