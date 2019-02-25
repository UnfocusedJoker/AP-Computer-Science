
public class Student {
	private String name = "";
	private int age = 0;
	
	public Student() {
		
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return "Name: " + name + "\nAge: " + age;
	}
}
