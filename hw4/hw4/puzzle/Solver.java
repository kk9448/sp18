package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.*;

public class Solver {
    private Queue<WorldState> q;

    private class Node extends Word{
        private int totalValue = 0;
        private int stepNum = 0;
        private Node pre = null;
        private boolean mark = false;
        /**
         * Creates a new Word.
         *
         * @param w
         * @param g
         */
        public Node(String w, String g) {
            super(w, g);
        }
        public void calTotal(){
            totalValue =  stepNum + estimatedDistanceToGoal();
        }

    }

    public Solver(WorldState initial){
        if (initial == null) {
            return;
        }
        if (initial.estimatedDistanceToGoal() == 0) {
            q.add(initial);
            return;
        }
        Node aNode = (Node) initial;
        MinPQ<Node> pq = new MinPQ<>(new CompareNode());
        q = new LinkedList<>();
        for (WorldState x : initial.neighbors()) {
            Node nodeX = (Node) x;
            if (nodeX.mark == false) {
                nodeX.stepNum++;
                nodeX.calTotal();
                nodeX.pre = aNode;
                nodeX.mark = true;
                pq.insert(nodeX);
            }
        }
        Node result = pq.delMin();
        while (result.estimatedDistanceToGoal() != 0) {
            if (pq.isEmpty()) {
                q = null;
                break;
            }
            result = pq.delMin();
            for (WorldState x : result.neighbors()) {
                Node nodeX = (Node) x;
                pq.insert(nodeX);
            }
        }

    }

    class CompareNode implements Comparator<Node> {
        @Override
        public int compare(Node t0, Node t1) {
            return t0.totalValue - t1.totalValue;
        }
    }


    public int moves(){
        return stepNum;
    }
    public Iterable<WorldState> solution() {
        return q;
    }
}
