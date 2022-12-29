import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
* 문제: 반복 수열
* 반복수열에서 반복되는 부분을 제외했을 때, 수열에 남게 되는 수들의 개수를 구한느 프로그램
* */
public class Baekjoon_2331{
    public static int[] check = new int[1000000];
    public static int count = 1;
    public static int nextNum(int num , int p)
    {
        int d = 0;

        while(num>0){
            d += Math.pow(num%10, p);
            num /=10;
        }

        return d;
    }
    public static int dfs(int a, int p){

        if(check[a] != 0)
        {
            return check[a]-1;
        }

        check[a] = count;
        int newA = nextNum(a, p);
        count ++;

        return dfs(newA, p);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        System.out.println(dfs(a, p));
    }
}
