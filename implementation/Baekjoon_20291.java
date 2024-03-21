import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 파일 정리
 */
public class Baekjoon_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> extensionMap = new HashMap<>();
        
        for(int i = 0; i<N ; i++){
            String fileName = br.readLine();
            String extension = fileName.split("\\.")[1];

            if(extensionMap.containsKey(extension)){
                extensionMap.put(extension, extensionMap.get(extension) + 1);
            }else{
                extensionMap.put(extension, 1);
            }
        }

        List<String> keySet = new ArrayList<>(extensionMap.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            sb.append(key + " ").append(extensionMap.get(key)).append("\n");
        }

        System.out.println(sb);
    }
}
