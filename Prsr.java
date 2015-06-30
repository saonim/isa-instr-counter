import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Prsr {
	public static void main (String args[]) throws IOException {
		if (args.length == 1) {
			String fName = args[0];
			parseFile(fName);
		}
		else {
			System.out.println("Usage: <exec> <filename>");
			System.exit(0);
		}
	}
	
	static void parseFile (String file) throws IOException {
		
		FileInputStream fstream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;
		int instrNum1 = 0;

		PrintWriter writer1 = new PrintWriter("op1.txt", "UTF-8");		
		
		while ((line = br.readLine()) != null)   {
			
			if (!line.isEmpty() && line.contains("//")) {
				instrNum1++;
				writer1.println(instrNum1 + " : " + line);
			}
		}
		
		System.out.println ("Total number of instructions: " + instrNum1);
		
		writer1.close();
		br.close();
		
	}
}
