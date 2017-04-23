/**
 * Created by michalsvacha on 23/04/17.
 */

public class ColorRules {

    public boolean isGoodNeighbor(int placed, int candidate) {
        if (placed == -1) {
            return true;
        } else if (placed == candidate) {
            return false;
        } else {
            switch (placed) {
                case 0:
                    return (candidate == 2 || candidate == 4 || candidate == 3);
                case 1:
                    return candidate == 4;
                case 2:
                    return (candidate == 0 || candidate == 4 || candidate == 5);
                case 3:
                    return candidate == 0;
                case 4:
                    return (candidate == 0 || candidate == 2 || candidate == 1);
                case 5:
                    return candidate == 2;
                default:
                    return true;
            }
        }
    }

    public String getPrettyOutput(String solution) {
        if (solution == "IMPOSSIBLE") {
            return solution;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < solution.length(); i++) {
            int index = Character.getNumericValue(solution.charAt(i));
            sb.append(this.getStringRepresentation(index));
        }
        return sb.toString();
    }

    private String getStringRepresentation(int index) {
        switch (index) {
            case 0:
                return "R";
            case 1:
                return "O";
            case 2:
                return "Y";
            case 3:
                return "G";
            case 4:
                return "B";
            case 5:
                return "V";
            default:
                return "";
        }
    }

    public boolean isValidSolution(String solution) {
        int first = Character.getNumericValue(solution.charAt(0));
        int last = Character.getNumericValue(solution.charAt(solution.length() - 1));
        return this.isGoodNeighbor(first, last);
    }
}
