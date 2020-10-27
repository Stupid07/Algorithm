import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        StringBuilder result = new StringBuilder();
        int i, len;
        while(line.compareTo("0") != 0){
            for(i = 0, len = line.length(); i < len; i++){
                if(line.charAt(i) != line.charAt(len-1-i)){
                    result.append("no\n");
                    break;
                }
            }

            if(i == len){
                result.append("yes\n");
            }
            line = reader.readLine();
        }
        System.out.print(result.toString());
    }
}
