/**
 * Created by kunqi
 * ON 7/12/18 12:28 AM
 */

//refer to : https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
// find shortest path from src to every other vertex

public class Dijkstra {

    private static int findMinDist(int[] dist, boolean[] spt){
        int len = dist.length;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < len; i++){
            if (!spt[i] && dist[i] < min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void printResult(int[] dist, int src){
        for (int i = 0; i<dist.length; i++){
            System.out.println("shortest distance from source " + src +
                    " to " + i + " is " + dist[i]);
        }
    }

    private static void dijkstra(int[][] g, int src){
        int V = g.length;
        boolean[] spt = new boolean[V];
        int[] dist = new int[V];
        for(int i = 0; i<V; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;
        for (int count = 0; count < V-1; count++){
            // pick min dist vertex from uncover set
            int u = findMinDist(dist,spt);
            spt[u] = true;
            // update distance of adjacent of u
            for (int j = 0; j < V; j++){
                if (!spt[j] && g[u][j] != 0 &&  dist[u] + g[u][j] < dist[j]){
                    dist[j] = dist[u] + g[u][j];
                }
            }
        }

        printResult(dist, src);
    }

    public static void main(String[] args){
        int[][] g = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        dijkstra(g,0);
    }
}
