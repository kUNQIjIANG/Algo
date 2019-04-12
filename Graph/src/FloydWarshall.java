import java.util.Arrays;

/**
 * Created by kunqi
 * ON Apr/13/2019 00:02
 */
// refer to: https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
// shortest path between every pair of vertex

public class FloydWarshall {
    private static final int INF = 999;

    private static int[][] floydWarshall(int[][] graph){
        int V = graph[0].length;
        int[][] dist = new int[V][V];
        // initialize as no intermediate used
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                dist[i][j] = graph[i][j];
            }
        }
        // k as intermediate
        for(int k = 0; k < V; k++){
            // update from every src i
            for(int i = 0; i < V; i++){
                // to every dest j
                for(int j = 0; j < V; j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {{0,   5,  INF, 10},
                         {INF, 0,   3, INF},
                         {INF, INF, 0,   1},
                         {INF, INF, INF, 0}};
        int[][] dist = floydWarshall(graph);
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (dist[i][j] == INF) System.out.print("INF ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
