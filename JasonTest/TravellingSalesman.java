import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class TravellingSalesman {

    public static int solve(int[][] adj) {
        int min = Integer.MAX_VALUE;
        // ArrayList<Integer> soln = new ArrayList<Integer>();
        // Consider every possible starting position
        myLinkedList<Integer> test = new myLinkedList<Integer>();
        for (Integer i = 0; i < adj.length; i++){
            test.add(i);
        }
        // one ele larger than we need
        int[] repeatNTimes = new int[adj.length + 1];
        ArrayList<String> allAnswers = new ArrayList<String>();
        allAnswers.add(test.toString());

        
        for(int x = 0; x <= repeatNTimes.length; x++){
            if (x == repeatNTimes.length - 1){
                break;
            }
            
            repeatNTimes[x] += 1;
            if (repeatNTimes[x] < x+1){
                test.substringReverse(x);
                // System.out.println(x);
                // System.out.println(test);
                allAnswers.add(test.toString());
                int sum = test.sum(adj); // optimize to include with the reverse function n^3 => n^2
                if(sum < min) {
                    min = sum;
                    // System.out.println(test.toString()); // delete later
                    // soln = first.fullPath();
                }
                while(x > 0){
                    x --;
                    repeatNTimes[x] = 0;
                }
            }
            

        }

        // System.out.println(soln);
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
        long start = System.currentTimeMillis();
        System.out.println(solve(adj));
        System.out.println((System.currentTimeMillis()-start)/1000.0);
        cin.close();
    }

    
}
