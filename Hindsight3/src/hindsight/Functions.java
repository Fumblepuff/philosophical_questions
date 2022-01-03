package hindsight;

import java.util.*;
import java.io.*;

public class Functions {
	
	//private Scanner scanner = new Scanner(System.in);
	private Stack<String> questions = new Stack<String>();
	private Stack<Integer> questionID = new Stack<Integer>();
	public String path = "src/hindsight/philosphylist copy.txt";
	
	public int Random() {
		int rand = new Random().nextInt(187);
		return rand;
	}
	
	public void questionReader() throws IOException {
		File filepath = new File(path);
		Scanner fileIn = null;
		fileIn = new Scanner(filepath);
		while (fileIn.hasNext()) {
			int question = Random();
			boolean valid = valid(question);
			if (valid) {
				questionID.add(question);
				String line = " ";
				for (int i = 0; i <= question; i++) {
					line = fileIn.nextLine();
				}
				System.out.println(line);
				questions.add(line);
			}
		}
		fileIn.close();
	}
	
	public boolean valid(int id) {
		HashSet<Integer> validator = new HashSet<Integer>();
		if (!validator.add(id)) {
			return false;
		}
		return true;
	}
	
}
