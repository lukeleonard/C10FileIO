//Authors: Casey Miller and Luke Leonard

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	//Constructor that creates the ArrayList of Students
	public ScoreTrakker() {
		students  =new ArrayList<Student>();
	}
	
	//Main that calls other functions
	public static void main(String [ ] args){
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles();
	}
	
	//Runs a loop that reads lines from a file
	public void loadDataFromFile(String name) throws FileNotFoundException {
		FileReader reader = new FileReader(name);
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()) {
			String readName = "";
			String readScore = "";
			int intScore = 0;
			readName = in.nextLine();
			readScore = in.nextLine();
			try {
			intScore = Integer.parseInt(readScore);
			}
			catch(NumberFormatException e){
				System.out.println("Incorrect format for " + readName + " not a valid score: " + readScore);
				System.out.println();
				continue;
			}
			students.add(new Student(readName,intScore));
		}
	}
	
	//Prints out the Students ArrayList after Sorting it
	public void printInOrder() {
		Collections.sort(students);
		System.out.println("Student Score List");
		for(Student student : students) {
			System.out.println(student);
		}
		System.out.println();
	}
	
	//Loads and Prints from a file
	public void processFiles(){
		for(String fileName : files) {
			try {
				loadDataFromFile(fileName);
			} catch (FileNotFoundException e) {
				System.out.println("Can't open file: " + fileName);
				System.out.println();
				continue;
			}
			printInOrder();
			students.clear();
		}
	}

}
