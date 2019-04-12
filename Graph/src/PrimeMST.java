
/**
 * Created by kunqi
 * ON Apr/12/2019 10:55
 */
// complexity: O(V^2)
public class PrimeMST {

    private static final int INF = Integer.MAX_VALUE;

    private static int primeMST(int[][]graph){
        int num = graph[0].length;
        boolean[] visited = new boolean[num];
        visited[0] = true;
        int min_edge;
        int src = 0;
        int dest = 0;
        int edgeSum = 0;
        for (int i = 0; i < num - 1; i++){
            min_edge = INF;
            // search for current min edge
            for (int j = 0; j < num; j++){
                // source vertex
                if (visited[j]){
                    // dest vertex
                    for (int k = 0; k < num; k++){
                        //greedy
                        if(!visited[k] && graph[j][k] < min_edge){
                            min_edge = graph[j][k];
                            src = j;
                            dest = k;
                            edgeSum+=min_edge;
                        }
                    }
                }
            }
            visited[dest] = true;
            System.out.printf("src: %d, dest: %d, edge: %d\n",src,dest,min_edge);
        }
        return edgeSum;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {{INF, 2, INF, 6, INF},
                                     {2, INF, 3, 8, 5},
                                     {INF, 3, INF, INF, 7},
                                     {6, 8, INF, INF, 9},
                                     {INF, 5, 7, 9, INF}};
        int ms = primeMST(graph);
        System.out.println(ms);
    }
}
