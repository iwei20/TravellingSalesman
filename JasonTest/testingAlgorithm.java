import java.util.*;
public class testingAlgorithm{
    public static void main(String[] args) {
        String[] eles = new String[]{"A", "B", "C", "D"};
        // , "E", "F", "G", "H"
        myLinkedList<String> test = new myLinkedList<String>();
        for (String i : eles){
            test.add(i);
        }
        // one ele larger than we need
        int[] repeatNTimes = new int[eles.length + 1];
        ArrayList<String> allAnswers = new ArrayList<String>();
        System.out.println(test);
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
                while(x > 0){
                    x --;
                    repeatNTimes[x] = 0;
                }
            }
            

        }
        System.out.println(allAnswers.size());
        System.out.println(allAnswers);

        System.out.println(Arrays.toString(repeatNTimes));
    }

}