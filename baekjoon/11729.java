import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader reader;
	public static BufferedWriter writer;
	public static StringBuilder builder;
	public static void main(String[] args) throws Exception{
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		int count = 1;
		for(int i = 1; i < n; i++){
		    count = (count<<1)+1;
		}
		builder = new StringBuilder(16);
		builder.append(count).append('\n');
		writer.write(builder.toString());
		builder.setLength(0);
		hanoiTower(n,1,3,2);
		writer.close();
	}
	
	public static void hanoiTower(int height, int location, int destination, int another) throws Exception{
		if(height > 0) {
			hanoiTower(height-1, location, another, destination);
			builder.append(location).append(' ').append(destination).append('\n');
			writer.write(builder.toString());
			builder.setLength(0);
			hanoiTower(height-1, another, destination, location);
		}
	}
}
