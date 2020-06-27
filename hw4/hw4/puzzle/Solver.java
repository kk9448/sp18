package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;

public class Solver {
    public Solver(WorldState initial){
        MinPQ<WorldState> pq = new MinPQ<>();
        for (WorldState x : initial.neighbors()) {
            pq.insert(x);
        }

    }
    public int moves(){
        return 0;
    }
    public Iterable<WorldState> solution(){
     return null;
    }
}
