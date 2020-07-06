package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.SET;

import java.util.*;

public class Solver {
    private Deque<WorldState> q;
    private Node result;
    int finalStepNumber;

    private class Node {
        private int totalValue = 0;
        private int stepNum = 0;
        private Node pre;
        private boolean mark = false;
//        private int es;
//        Iterable<WorldState> it;
        WorldState ws;

        public Node (WorldState x) {
            ws = x;
//            es = x.estimatedDistanceToGoal();
//            it = x.neighbors();
        }

        public void calTotal(){
            totalValue =  stepNum + ws.estimatedDistanceToGoal();
        }

    }

    public Solver(WorldState initial){
        if (initial == null) {
            return;
        }
        Node aNode = new Node(initial);
        MinPQ<Node> pq1 = new MinPQ<>(new CompareNode());
        Set<WorldState> checkReuse= new HashSet<>();
        q = new ArrayDeque<>();
        aNode.mark = true;
        pq1.insert(aNode);
        checkReuse.add(aNode.ws);
        result = pq1.delMin();
        int stepNumber = 0;
        while (result.ws.estimatedDistanceToGoal() != 0) {
            stepNumber = stepNumber + 1;
            for (WorldState x : result.ws.neighbors()) {
                Node nodeX = new Node(x);

                if (checkReuse.contains(x) == false) {
                    nodeX.stepNum = stepNumber;
                    nodeX.calTotal();
                    nodeX.pre = result;
//                    nodeX.mark = true;
                    checkReuse.add(x);
                    pq1.insert(nodeX);
                }
            }
            if (pq1.isEmpty()) {
                result = null;
                break;
            }
            result = pq1.delMin();
        }

        finalStepNumber = result.stepNum;

        if (result != null) {
            while (result.pre != null) {
                q.addFirst(result.ws);
                result = result.pre;
            }
            q.addFirst(aNode.ws);
//            Collections.reverse(q);
        }
    }

    class CompareNode implements Comparator<Node> {
        @Override
        public int compare(Node t0, Node t1) {
            return t0.totalValue - t1.totalValue;
        }
    }


    public int moves(){
        return finalStepNumber;
    }
    public Iterable<WorldState> solution() {
        return q;
    }
}
