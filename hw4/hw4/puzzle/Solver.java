package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


//import java.util.*;

public class Solver {
    private Deque<WorldState> q;
    private Node result;
    private int finalStepNumber;

    private class Node {
        private int totalValue = 0;
        private int stepNum = 0;
        private Node pre;
        WorldState ws;
        Node(WorldState x) {
            ws = x;
        }
        public int calTotal() {
            return totalValue = stepNum + ws.estimatedDistanceToGoal();
        }
    }
    public Solver(WorldState initial) {
        if (initial == null) {
            return;
        }
        Node aNode = new Node(initial);
        MinPQ<Node> pq1 = new MinPQ<>(new CompareNode());
        Map<WorldState, Integer> alreadyBeen = new HashMap<>();
        q = new ArrayDeque<>();
//        pq1.insert(aNode);
//        result = pq1.delMin();
        result = aNode;
        while (result.ws.estimatedDistanceToGoal() != 0) {
            for (WorldState x : result.ws.neighbors()) {
                Node nodeX = new Node(x);
                int newTotal = result.stepNum + 1 + x.estimatedDistanceToGoal();
//              DONE: if the previous num is small, can not update yje step number;
                if (alreadyBeen.get(x) == null) {
                    nodeX.pre = result;
                    nodeX.stepNum = result.stepNum + 1;
                    nodeX.totalValue = nodeX.calTotal();
                    pq1.insert(nodeX);
/**                  alreadyBeen.put(x, total);不能加在这里,只能在remove PQ后 */
//              Done: update pre pointer;
                } else if (alreadyBeen.get(x) > newTotal) {
                    nodeX.pre = result;
                    nodeX.totalValue = newTotal;
                    pq1.insert(nodeX);
/**                 alreadyBeen.put(x, total);不能加在这里, 只能在remove PQ后 */
                }
            }
            if (pq1.isEmpty()) {
                result = null;
                break;
            }
            result = pq1.delMin();
            alreadyBeen.put(result.ws, result.totalValue);
        }
        if (result != null) {
            while (result.pre != null) {
                q.addFirst(result.ws);
                result = result.pre;
                finalStepNumber++;
            }
            q.addFirst(aNode.ws);
        }
    }
    private class CompareNode implements Comparator<Node> {
        @Override
        public int compare(Node t0, Node t1) {
            return t0.totalValue - t1.totalValue;
        }
    }
    public int moves() {
        return finalStepNumber;
    }
    public Iterable<WorldState> solution() {
        return q;
    }
}
