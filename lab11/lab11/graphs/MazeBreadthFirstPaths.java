package lab11.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private Deque nodeSeries;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        nodeSeries = new ArrayDeque();
        // Add more variables here!
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs(int v) {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
        marked[v] = true;
        announce();

        if (v == t) {
            targetFound = true;
        }

        if (targetFound) {
            return;
        }

        for (int w : maze.adj(v)) {
            if (!marked[w]) {
                marked[w] = true;
                edgeTo[w] = v;
                announce();
                distTo[w] = distTo[v] + 1;
                if (v == t) {
                    targetFound = true;
                }
                if (targetFound) {
                    return;
                } else {
                    nodeSeries.addLast(w);

                }
            }
        }
        bfs((Integer) nodeSeries.removeFirst());
    }


    @Override
    public void solve() {
         bfs(s);
    }
}

