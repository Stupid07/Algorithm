import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String word = reader.readLine();
		int result = word.length() - word.replaceAll("[aeiou]", "").length();
		writer.write("" + result);
		writer.flush();
		writer.close();
	}
}