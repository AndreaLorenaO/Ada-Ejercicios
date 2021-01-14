package db.inicial.model;

public class Registration {

	private int registrationId;
	private int courseId;
	private int studentId;
	private int professorId;
	private int commission;
	private int evaluation1;
	private int evaluation2;
	private int state;

	public Registration(int courseId, int studentId, int professorId, int commission, int evaluation1, int evaluation2,
			int state) {
		this.courseId = courseId;
		this.studentId = studentId;
		this.professorId = professorId;
		this.commission = commission;
		this.evaluation1 = evaluation1;
		this.evaluation2 = evaluation2;
		this.state = state;
	}

	public Registration(int courseId, int studentId, int commission) {
		this.courseId = courseId;
		this.studentId = studentId;
		this.commission = commission;
	}

	public Registration(int courseId, int studentId, int professorId, int commission, int state) {
		this.courseId = courseId;
		this.studentId = studentId;
		this.professorId = professorId;
		this.commission = commission;
		this.state = state;
	}

	public Registration(int registrationId, int courseId, int studentId, int commission) {
		this.registrationId = registrationId;
		this.courseId = courseId;
		this.studentId = studentId;
		this.commission = commission;
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

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String toString() {
		return registrationId + " - " + courseId + " - " + studentId + " - " + professorId + " - " + commission + " - "
				+ state;
	}

}
