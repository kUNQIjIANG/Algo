/**
 * Created by kunqi
 * ON 7/9/18 10:54 PM
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static void bfs_v2(int src, Graph G){
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> p = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()){
            int cur = q.remove();
            if (!p.contains(cur)){
                p.add(cur);
                Iterator<Integer> c = G.adj[cur].listIterator();
                while(c.hasNext()){
                    int neigh = c.next();
                    q.add(neigh);
                }
            }
        }

        System.out.println("bfs");
        for (int i : p){
            System.out.print(i+"->");
        }
    }

    static void bfs(int src, Graph G){

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[G.num];
        q.add(src);
        visited[src] = true;
        int[] dist = new int[G.num];

        while (!q.isEmpty()){
            int n = q.remove();
            System.out.print(n+"->");
            Iterator<Integer> c = G.adj[n].listIterator();
            while(c.hasNext()){
                int s = c.next();
                if(!visited[s]){
                    visited[s] = true;
                    q.add(s);
                    dist[s] = dist[n] + 1;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < dist.length; i++) {
            System.out.println("shortest dist from src "
                    + src + " to " + i + " is " + dist[i]);
        }

    }

    public static void main(String[] args){
        Graph g = new Graph(7);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,5);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,1);
        g.addEdge(4,2);
        g.addEdge(5,6);
        g.addEdge(5,4);
        g.addEdge(6,3);
        g.addEdge(6,1);
        g.addEdge(6,4);



        System.out.println("Starting from vertex 2");
        BFS.bfs(2,g);
        BFS.bfs_v2(2,g);
    }
}
