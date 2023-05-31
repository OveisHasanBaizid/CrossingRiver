import java.util.LinkedList;

public class SearchAlgorithm {
    private final LinkedList<Node> unexpandedNodes;
    private final LinkedList<Node> expandedNodes;

    public SearchAlgorithm() {
        unexpandedNodes = new LinkedList<>();
        expandedNodes = new LinkedList<>();
    }

    private boolean isValid(Node node) {
        if (!node.thiefWithPolice())
            return false;
        if (!node.motherWithSon())
            return false;
        if (!node.fatherWithDaughter())
            return false;
        if (!node.boatDriver())
            return false;
        return node.boatPassenger();
    }

    private boolean isGoal(Node node) {
        return node.isGoal();
    }

    private LinkedList<Node> generateChildren(Node node){
        Node sampleNode;
        boolean[] state = new boolean[9];

        LinkedList<Node> children = new LinkedList<>();

        for (int i = 1; i < 9; i++) {
            for (int j = i; j < 9; j++) {
                if (state[0]) {
                    if (state[i] && state[j]) {
                        state[0] = false;
                        state[i] = false;
                        state[j] = false;
                        sampleNode = new Node(node,state);
                        if (isValid(sampleNode))
                            children.add(sampleNode);
                        state = new boolean[9];
                    }
                } else {
                    if (!state[i] && !state[j]) {
                        state[0] = true;
                        state[i] = true;
                        state[j] = true;
                        sampleNode = new Node(node,state);
                        if (isValid(sampleNode))
                            children.add(sampleNode);
                        state = new boolean[9];
                    }
                }
            }
        }
        return children;
    }

    public Node search(Node startNode) {
        // 1
        unexpandedNodes.add(startNode);
        while (true) {
            // 2
            if (unexpandedNodes.size() == 0)
                return null;
            // 3
            Node target = unexpandedNodes.getLast();
            // 4
            unexpandedNodes.removeLast();
            // 5
            if (!isValid(target))
                continue;
            // 6
            if (isGoal(target))
                return target;
            // 7
            if (isExpandedNodes(target))
                continue;
            // 8
            for (Node n : generateChildren(target)) {
                unexpandedNodes.addLast(n);
            }
            // 9
            expandedNodes.add(target);
        }

    }

    public boolean isExpandedNodes(Node node) {
        for (Node expandedNode : expandedNodes) {
            if (expandedNode.equals(node))
                return true;
        }
        return false;
    }
}
