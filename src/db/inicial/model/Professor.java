package db.inicial.model;

public class Professor extends Person {

	public Professor(int id, String name, String lastname, String email, String cellphone) {
		super(id, name, lastname, email, cellphone);
	}

	public Professor(String name, String lastname, String email, String cellphone) {
		super(name, lastname, email, cellphone);
	}

	public Professor(int id) {
		super(id);
	}

	public Professor(int id, String name) {
		super(id, name);
	}

	public Professor(int id, String name, String lastname) {
		super(id, name, lastname);
	}

}
