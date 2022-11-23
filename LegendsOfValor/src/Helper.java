import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// this class can help the Scanner in to work  to drop some bad input  or check whether the int has go out of bound
public class Helper {

    private static Scanner scan = new Scanner(System.in);


    public static int interact(String s){
//        StackTraceElement traceElement = ((new Exception()).getStackTrace())[0];
        StackTraceElement traceElement[] = ((new Exception()).getStackTrace());

        for (StackTraceElement tr :
                traceElement) {
            System.out.println(tr.getMethodName());
        }

        return 0;
    }

    public static int getIntInput(String s,int upper){

        int ret = 0;
        System.out.println(s);
        while (true) {
            String in = scan.nextLine();
            //try to convert it to a int
            try {
                ret = Integer.parseInt(in);
                // Input is not an integer
            } catch (Exception e) {
                System.out.println("Invalid input. Must be an integer less than"+(upper+1));
                continue;
            }
            // input size are not expected
            if (ret < 1 || ret > upper) {
                System.out.println("Invalid input. Must between 1 and "+upper);
                continue;
            }
            return ret;
        }
    }

    public static char getCharInput(String instruction){

        ArrayList<Character> chs = new ArrayList<>();

        Pattern pattern = Pattern.compile("\'\\w\'");
        Matcher matcher = pattern.matcher(instruction);

        while (matcher.find()){
            int matcherStart = matcher.start(); //matcher.end();
            chs.add(instruction.charAt(matcher.start()+1));

        }

        while(true) {
            System.out.println(instruction);
            String in = scan.nextLine();

            if(in.length()<1){
                System.out.println("Please enter a valid input!");
                continue;
            }
            char c = in.charAt(0);
            if(chs.contains(c)){
                return c;
            }else {
                System.out.println("Please enter a valid input!");
                continue;
            }

        }
    }
}
