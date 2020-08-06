package lab11.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private int s;
    private int t;
    private boolean circleFound = false;
    private Maze maze;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        s = 1;
        t = m.N() * m.N();
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    private void dfs(int v) {
        if(circleFound == true) {
            return;
        }
        marked[v] = true;
        announce();
        for (int w : maze.adj(v)) {
            /** use distance*/
//            if (marked[w] == true && distTo[w] != distTo[v] - 1) {
//                edgeTo[w] = v;
//                circleFound = true;
//                announce();
//                return;
//            }
            /** use father Node*/
            if (marked[w] == true && edgeTo[v] != w) {
                edgeTo[w] = v;
                circleFound = true;
                announce();
                return;
            }
            if (!marked[w]) {
                edgeTo[w] = v;
                distTo[w] = distTo[v] + 1;
                dfs(w);
                if(circleFound == true) {
                    return;
                }
            }
        }
    }

    @Override
    public void solve() {
        // DONE: Your code here!
        dfs(s);
    }
    // Helper methods go here
}

