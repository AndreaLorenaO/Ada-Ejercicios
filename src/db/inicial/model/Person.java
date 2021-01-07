package db.inicial.model;

public class Person {

	protected int id;
	protected String name;
	protected String lastname;
	protected String email;
	protected String cellphone;

	public Person(int id, String name, String lastname, String email, String cellphone) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.cellphone = cellphone;
	}

	public Person(String name, String lastname, String email, String cellphone) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.cellphone = cellphone;
	}

	public Person(int id) {
		this.id = id;
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Person(int id, String name, String lastname) {
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

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

}
