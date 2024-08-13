import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * A -> B
 */
public class Baekjoon_16953 {
	static long b;
	public static class Pos{
		long x;
		int count;

		public Pos(long x, int count){
			this.x = x;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		System.out.println(bfs(a));
	}

	public static long bfs(long x){
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(x, 1));

		while (!queue.isEmpty()){
			Pos poll = queue.poll();
			long newX1 = poll.x*10 + 1;
			if(newX1<=b) {
				queue.add(new Pos(newX1, poll.count + 1));
			}
			if(newX1 == b){
				return poll.count + 1;
			}
			newX1 = poll.x*2;
			if(newX1<=b) {
				queue.add(new Pos(newX1, poll.count + 1));
			}
			if(newX1 == b){
				return poll.count + 1;
			}
		}
		return -1;
	}
}
