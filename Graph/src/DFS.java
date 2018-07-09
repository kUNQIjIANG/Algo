import java.util.Iterator;
import java.util.Stack;

/**
 * Created by kunqi
 * ON 7/10/18 12:08 AM
 */

public class DFS {
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

    public static void main(String[] arg){
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);

        System.out.println("start from 2");
        DFS.recursiveDfs(2,g);
    }
}
