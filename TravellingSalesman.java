import java.util.ArrayList;
import java.util.Scanner;
public class TravellingSalesman {

    public static int solve(int[][] adj) {
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> soln = new ArrayList<Integer>();
        // Consider every possible starting position
        for(int i = 0; i < adj.length; ++i) {
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
                    if(first.getCost() < min) {
                        min = first.getCost();
                        soln = first.fullPath();
                    }
                    
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
        for(int i = 0; i < soln.size(); ++i) soln.set(i, soln.get(i) + 1);
        System.out.println(soln);
        return min;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<String>();
        ArrayList<String> cityNames = new ArrayList<String>();

        while(cin.hasNextLine()) {
            String line = cin.nextLine();
            lines.add(line);
            String[] s = line.split(" ");

            if(!cityNames.contains(s[0])) {
                cityNames.add(s[0]);
            }

            if(!cityNames.contains(s[2])) {
                cityNames.add(s[2]);
            }
        }

        int[][] adj = new int[cityNames.size()][cityNames.size()];
        for(int i = 0; i < lines.size(); ++i) {
            String[] s = lines.get(i).split(" ");
            int first = cityNames.indexOf(s[0]);
            int second = cityNames.indexOf(s[2]);
            int dist = Integer.parseInt(s[4]); 
            adj[first][second] = adj[second][first] = dist;
        }
        System.out.println(solve(adj));
        cin.close();
    }

    
}
