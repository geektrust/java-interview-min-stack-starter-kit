import java.util.ArrayList;
import java.util.List;

public class Main {

    /* Implement your solution inside this method. */
   public int[] handle(String[] operations, List<List<Integer>> parameters) {
    // WRITE YOUR CODE HERE.

    return null;
   }


    /*
     * *****************************************************************************
     * DO NOT EDIT THIS CODE.
     * *****************************************************************************
     * 
     * This code is used to boostrap your solution to be checked for correctness by
     * our system.
     */
    public static void main(String[] args) {
        String input = args[0];

        // Split into operations and parameters
        String[] parts = input.split("\\s*\\|\\s*");

        String operationsRaw = parts[0].trim();
        String parametersRaw = parts[1].trim();

        // ---- Parse operations ----
        operationsRaw = operationsRaw.replaceAll("[\\[\\]\"]", "");
        String[] operations = operationsRaw.split("\\s*,\\s*");

        // ---- Parse parameters ----
        List<List<Integer>> parameters = new ArrayList<>();

       
        String normalized = parametersRaw
                .replaceAll("^\\[\\[", "")
                .replaceAll("]]$", "")
                .replaceAll("\\],\\[", "]|[");  // delimiter safe for splitting

        String[] paramGroups = normalized.split("\\|");

        for (String group : paramGroups) {
            group = group.replaceAll("[\\[\\]]", "").trim();
            List<Integer> paramList = new ArrayList<>();

            if (!group.isEmpty()) {
                for (String num : group.split(",")) {
                    if (!num.trim().isEmpty()) {
                        paramList.add(Integer.parseInt(num.trim()));
                    }
                }
            }
            parameters.add(paramList);
        }
        
        int[] out = new Main().handle(operations, parameters);
        System.out.println(out);
    }
}

