public class Node {
    private final Node fatherNode;
    /*
    0 -> Boat
    1 -> Police
    2 -> Thief
    3 -> Father
    4 -> Mother
    5 -> Son 1
    6 -> Son 2
    7 -> Daughter 1
    8 -> Daughter 2
     */
    private boolean[] state;

    public Node() {
        state = new boolean[9];
        fatherNode = null;
    }

    public boolean equals(Node node) {
        for (int i = 0; i < 9; i++) {
            if (state[i] != node.state[i])
                return false;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"Boat's Latest Transfer:").append("\n");
        stringBuilder.append(!state[0] ? "Region1" : "Region2").append("\n\n");
        for (int i = 1; i < 9; i++) {
            if (!state[i])
                stringBuilder.append(getNameState(i)).append("\n");
        }
        stringBuilder.append("\n\n").append("Region2:\n");
        for (int i = 1; i < 9; i++) {
            if (state[i])
                stringBuilder.append(getNameState(i)).append("\n");
        }
        return stringBuilder.toString();
    }

    public String getNameState(int i) {
        String s = null;
        switch (i) {
            case 0 -> s = "Boat";
            case 1 -> s = "Police";
            case 2 -> s = "Thief";
            case 3 -> s = "Father";
            case 4 -> s = "Mother";
            case 5 -> s = "Son1";
            case 6 -> s = "Son2";
            case 7 -> s = "Girl1";
            case 8 -> s = "Girl2";
        }
        return s;
    }

    public Node clone() {
        return null;
    }
    public Node getFatherNode() {
        return fatherNode;
    }
    public boolean motherWithSon() {
        boolean b = state[4] == state[5] || state[4] == state[6];
        return b && !(state[3] == state[4]);
    }

    public boolean fatherWithDaughter() {
        boolean b = state[3] == state[7] || state[3] == state[8];
        return b && !(state[4] == state[3]);
    }

    public boolean boatDriver() {
        return (state[0] == state[1]) || (state[0] == state[3]) || (state[0] == state[4]);
    }

    public boolean boatPassenger() {
        for (int i = 1; i < 9; i++) {
            if (state[0] == state[i])
                return true;
        }
        return false;
    }

    public boolean thiefWithPolice() {
        for (int i = 3; i < 9; i++) {
            if ((state[2] == state[i]) && (state[1] != state[2]))
                return false;
        }
        return true;
    }

    public boolean isGoal() {
        for (int i = 0; i < 9; i++) {
            if (!state[i])
                return false;
        }
        return true;
    }
}
