import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by kunqi
 * ON Apr/12/2019 14:03
 */
// refer to: https://www.geeksforgeeks.org/?p=26604/

public class KruskalMST {
    private static final int INF = Integer.MAX_VALUE;
    static class Edge implements Comparable<Edge>{
        int src, dest, weight;
        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        public int compareTo(Edge edge){
            return this.weight - edge.weight;
        }
    }

    static class Subset{
        // rank is num of node in subset
        int parent, rank;
        Subset(int parent, int rank){
            this.parent = parent;
            this.rank = rank;
        }
    }
    // find the parent(subset) node x belong to
    static int find(Subset[] subsets, int x){
        // path compression
        if (subsets[x].parent != x){
            subsets[x].parent = find(subsets,subsets[x].parent);
        }
        return subsets[x].parent;
    }
    // union two different subsets
    static void union(Subset[] subsets, int x, int y){
        int px = find(subsets,x);
        int py = find(subsets,y);
        if (px != py){
            if (subsets[px].rank > subsets[py].rank) {
                subsets[py].parent = px;
            } else if (subsets[px].rank < subsets[py].rank) {
                subsets[px].parent = py;
            } else {
                subsets[py].parent = px;
                subsets[px].rank++;
            }
        }
    }

    private static int kruskalMST(int[][] graph){
        int vs = graph[0].length;
        List<Edge> edgeList = new ArrayList<>();
        for(int i = 0; i < vs; i++){
            for (int j = i+1; j < vs; j++){
                if (graph[i][j] != INF){
                    edgeList.add(new Edge(i,j,graph[i][j]));
                }
            }
        }
        Subset[] subsets = new Subset[vs];
        for (int i = 0; i < vs; i++){
            subsets[i] = new Subset(i,1);
        }
        // 从小到大
        Collections.sort(edgeList);
        int edgeSum = 0;
        int edgeAdded = 0;
        int index = 0;
        while(edgeAdded < vs-1){
            Edge edge = edgeList.get(index++);
            int src = edge.src;
            int dest = edge.dest;
            int srcParent = find(subsets,src);
            int destParent = find(subsets,dest);
            // 并查集避免成环，否则跳过该边
            if (srcParent != destParent){
                edgeSum += edge.weight;
                edgeAdded++;
                union(subsets,srcParent,destParent);
                System.out.printf("src: %d, dest: %d, edge: %d\n",src,dest,edge.weight);
            }
        }
        return edgeSum;
    }

    public static void main(String[] args){
        int graph[][] = new int[][] {{INF, 2, INF, 6, INF},
                {2, INF, 3, 8, 5},
                {INF, 3, INF, INF, 7},
                {6, 8, INF, INF, 9},
                {INF, 5, 7, 9, INF}};
        System.out.printf("min sum of MST: %d",kruskalMST(graph));
    }
}
