import sun.awt.image.ImageWatched;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by kunqi
 * ON 7/10/18 12:08 AM
 */

public class DFS {

    static void dfs_v2(int v, Graph g){
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> traverse = new LinkedList<>();
        stack.push(v);
        while (!stack.isEmpty()){
            int cur = stack.pop();
            if (!traverse.contains(cur)){
                traverse.add(cur);
                Iterator<Integer> neighs = g.adj[cur].listIterator();
                while(neighs.hasNext()){
                    int neigh = neighs.next();
                    stack.push(neigh);
                }
            }
        }

        System.out.println("dfs");
        for (int i : traverse){
            System.out.print(i+"->");
        }
    }

    // non-recursive
    static void dfs(int v, Graph g){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[g.num];
        stack.push(v);
        visited[v] = true;
        while(!stack.isEmpty()){
            v = stack.pop();
            System.out.print(v+"->");
            Iterator<Integer> i = g.adj[v].listIterator();
            while(i.hasNext()){
                int c = i.next();
                if (!visited[c]){
                    visited[c] = true;
                    stack.push(c);
                }
            }
        }
    }

    static void dfsUtil(int v, Graph g, boolean[] visited){
        System.out.print(v+"->");
        visited[v] = true;
        Iterator<Integer> i = g.adj[v].listIterator();
        while(i.hasNext()){
            int c = i.next();
            if (!visited[c]) dfsUtil(c,g,visited);
        }
    }

    static void recursiveDfs(int v, Graph g){
        boolean[] visited = new boolean[g.num];
        dfsUtil(v,g,visited);
    }

    static void recurDfs(int v, LinkedList<Integer> visited, Graph g){
        if (!visited.contains(v)){
            System.out.print(v+"->");
            visited.add(v);
            Iterator<Integer> neighs = g.adj[v].listIterator();
            while (neighs.hasNext()){
                int neigh = neighs.next();
                recurDfs(neigh,visited,g);
            }
        }
    }

    public static void main(String[] arg){
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

        System.out.println("start from 2");
        DFS.recursiveDfs(2,g);
        System.out.println();
        DFS.dfs_v2(2,g);
        System.out.println();
        LinkedList<Integer> visited = new LinkedList<>();
        recurDfs(2,visited,g);


    }
}
