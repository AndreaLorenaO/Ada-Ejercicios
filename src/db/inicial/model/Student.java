package db.inicial.model;

public class Student extends Person {

	private String faculty;

	public Student(int id, String name, String lastname, String email, String cellphone, String faculty) {
		super(id, name, lastname, email, cellphone);
		this.faculty = faculty;
	}

	public Student(String name, String lastname, String email, String cellphone, String faculty) {
		super(name, lastname, email, cellphone);
		this.faculty = faculty;
	}

	public Student(int id) {
		super(id);
	}

	public Student(int id, String name) {
		super(id, name);
	}

	public Student(int id, String name, String lastname) {
		super(id, name, lastname);
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

}
