package hindsight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Questions {
	
	private static HashSet<Integer> questions = new HashSet<Integer>();
	private static String path = "/Users/johnkalu/eclipse-workspace/Hindsight3/src/hindsight/philosphylist.txt";
	public static boolean run = true;

	public static void main(String[] args) {
		while (run) {
			pick();
		}

	}
	
	public static String prompt(){
		System.out.println("");
		System.out.println("Press ENTER for next question or 2 for questions list...");
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        switch(command) {
        case "2":
        	System.out.println(questions);
        	questions.clear();
        	break;
        case "done":
        	input.close();
        	run = false;
        	break;
        }
        for (int i = 0; i < 20; i++) {
        	System.out.print("-");
        }
        System.out.println("");
        
        return command;
	}
	
	public static void pick() {
		boolean check = false;
		int rand = new Random().nextInt(392);
		if (run) {
			if (!prompt().equals("2") || !prompt().equals("done")) {
				while (!check) {
					try {
						String question = Files.readAllLines(Paths.get(path)).get(rand);
						if (!question.contains("(DONE)") && questions.add(rand + 1)) {
							System.out.println(question);
							check = true;
						}
					}
					
					catch (IOException e){
						System.out.println(e);
						run = false;
					}
				}
			}
		}
	}
	


}
