import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 단어 뒤집기 2
 */
public class Baekjoon_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        int start = 0;
        int end = 0;

        while(true){
            if(input.contains("<") && input.contains(">")){
                if(input.indexOf("<") == 0){
                    end = input.indexOf(">");
                    String splitInput = input.substring(start, end+1);
                    sb.append(splitInput);
                    input = input.substring(end+1, input.length());
                }
                else{
                    end = input.indexOf("<");
                    String splitInput = input.substring(start, end);
                    sb.append(inverseInput(splitInput));
                    input = input.substring(end, input.length());
                }
            }else{
                sb.append(inverseInput(input));
                break;
            }
        }

        System.out.println(sb);
    }

    private static String inverseInput(String input){
        String inverse = "";

        while (true){
            int start = 0;
            if(input.contains(" ")){
                int end = input.indexOf(" ");
                String splitInput = input.substring(start, end);

                for(int i = splitInput.length() -1; i>=0; i--){
                    inverse += input.charAt(i);
                }

                inverse += " ";
                input = input.substring(end+1, input.length());
            }
            else{
                for(int i = input.length() -1; i>=0; i--){
                    inverse += input.charAt(i);
                }

                break;
            }
        }

        return inverse;
    }

}