package db.inicial.model;

public class Student {

	private int id;
	private String name;
	private String lastname;
	private String email;
	private String cellphone;
	private String faculty;

	public Student(String name, String lastname, String email, String cellphone, String faculty) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.cellphone = cellphone;
		this.faculty = faculty;
	}

	public Student(String name) {
		this.name = name;
	}

	public Student(int id) {
		this.id = id;
	}

	public Student(int id, String name, String lastname) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String celphone) {
		this.cellphone = celphone;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

}
