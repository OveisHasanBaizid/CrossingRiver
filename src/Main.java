public class Main {
    public static int transferIndex = 0;

    public static Node initialState() {
        return new Node();
    }
    public static void show(Node node) {
        String str = "\n------------------------------------\n"
                + "Transfer index: " + transferIndex + "\n" + node.toString() +
                "------------------------------------\n";
        System.out.println(str);
    }

    public static void showPath(Node node) {
        if (node == null)
            return;
        show(node);
        showPath(node.getFatherNode());
    }

    public static void main(String[] args) {
        SearchAlgorithm searchAlgorithm = new SearchAlgorithm();
        Node firstNode = initialState();
        Node result = searchAlgorithm.search(firstNode);
        showPath(result);
    }
}