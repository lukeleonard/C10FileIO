//Authors: Casey Miller and Luke Leonard

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	ArrayList<Student> students;
	//Constructor that creates the ArrayList of Students
	public ScoreTrakker() {
		students  =new ArrayList<Student>();
	}
	
	//Main that calls other functions
	public static void main(String [ ] args) throws FileNotFoundException {
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles();
	}
	
	//Runs a loop that reads lines from a file
	public void loadDataFromFile(String name) throws FileNotFoundException {
		FileReader reader = new FileReader(name);
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()) {
			String readName = in.nextLine();
			int readScore = Integer.valueOf(in.nextLine());
			students.add(new Student(readName,readScore));
		}
	}
	
	//Prints out the Students ArrayList after Sorting it
	public void printInOrder() {
		Collections.sort(students);
		System.out.println("Student Score List");
		for(Student student : students) {
			System.out.println(student);
		}
	}
	
	//Loads and Prints from a file
	public void processFiles() throws FileNotFoundException {
		loadDataFromFile("scores.txt");
		printInOrder();
	}

}
