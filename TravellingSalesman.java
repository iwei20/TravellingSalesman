import java.util.ArrayList;
import java.util.Scanner;
public class TravellingSalesman {

    public static int solve(int[][] adj) {
        int min = Integer.MAX_VALUE;
        // Consider every possible starting position
        for(int i = 0; i < adj.length; ++i) {
            // We are not allowed to use queues because we haven't learned them
            ArrayList<Path> perms = new ArrayList<Path>();

            // First create a path
            perms.add(new Path(adj.length));
            perms.get(0).add(i, 0);

            // From that starting position, continue through all paths until we have 
            while(perms.size() > 0) {
                // Consider an arbitrary path
                Path first = perms.remove(perms.size() - 1);

                if(first.finished()) {
                    // A complete path can be measured against the minimum path
                    min = Math.min(first.getCost(), min);
                } else {
                    // Otherwise, append all other connected cities that have not been previously visited
                    for(int j = 0; j < adj.length; ++j) {
                        if(!first.contains(j)) {
                            perms.add(first.clone().add(j, adj[first.getLastVisited()][j]));
                        }
                    }
                }

            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList<String> cityNames = new ArrayList<String>();

        // TODO: finish parsing
        while(cin.hasNextLine()) {
            String line = cin.nextLine();
            String[] s = line.split(" ");

            if(!cityNames.contains(s[0])) {
                cityNames.add(s[0]);
            }

            if(!cityNames.contains(s[2])) {
                cityNames.add(s[2]);
            }
        }
        cin.close();
        cin = new Scanner(System.in);

    }

    
}
