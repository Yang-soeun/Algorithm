import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 분수찾기
 */
public class Baekoon_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int cross = 1;//대각선에 있는 원소의 개수
        int preSum = 0;//현재 대각선 전까지 원소의 개수
        int pos;

        while(true){
            if(x <= preSum + cross){
                if(cross%2 == 1){//대각선의 개수 홀수
                    pos = x - preSum;
                    System.out.println((cross-(pos - 1)) + "/" + pos);
                    break;
                }else{
                    pos = x - preSum;
                    System.out.println(pos + "/" + (cross-(pos-1)));
                    break;
                }
            }
            else{
                preSum += cross;
                cross++;
            }
        }
    }
}
