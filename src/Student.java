//Authors: Luke Leonard Casey Miller

public class Student implements Comparable<Student> {
	private String name;
	private int score;
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	//Constructor
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
		
	}
	//Comparing function using primative ints
	@Override
	public int compareTo(Student input) {
		if (input.getScore() == this.score) {
			return 0;
		}else if(input.getScore() > this.score){
			return 1;
		}else {
			return -1;
		}
	}

	//to string
	@Override
	public String toString() {
		return name + " " + score ;
	}
	

}
