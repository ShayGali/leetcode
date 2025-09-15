package algorithms.easy.find_center_of_star_graph_1791;

public class Solution {
    public int findCenter(int[][] edges) {
        // the vertex is either edges[0][0] or edges[0][1]
        // we can check if edges[0][0] or edges[0][1] are in the second edge
        // if it is, then it is the center
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        return edges[0][1];
    }
}
