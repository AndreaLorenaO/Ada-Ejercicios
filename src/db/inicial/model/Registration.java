package db.inicial.model;

public class Registration {

	private int id;
	private int courseId;
	private int studentId;
	private int professorId;
	private int commission;
	private int evaluation1;
	private int evaluation2;
	private boolean state;

	public Registration(int courseId, int studentId, int commission) {
		this.courseId = courseId;
		this.studentId = studentId;
		this.commission = commission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public int getEvaluation1() {
		return evaluation1;
	}

	public void setEvaluation1(int evaluation1) {
		this.evaluation1 = evaluation1;
	}

	public int getEvaluation2() {
		return evaluation2;
	}

	public void setEvaluation2(int evaluation2) {
		this.evaluation2 = evaluation2;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}
