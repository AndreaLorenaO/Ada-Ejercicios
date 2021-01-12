package db.inicial.model;

public class Course {

	private int id;
	private String name;
	private String schedule;
	private String duration;
	private String start;
	private String end;
	private int professorId;

	public Course(String nombreCurso) {
		this.name = nombreCurso;
	}

	public Course(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Course(String name, String schedule, String duration, String start, String end, int professorId) {
		this.name = name;
		this.schedule = schedule;
		this.duration = duration;
		this.start = start;
		this.end = end;
		this.professorId = professorId;
	}

	public Course(int id, String name, String schedule, String duration, String start, String end, int professorId) {

		this.id = id;
		this.name = name;
		this.schedule = schedule;
		this.duration = duration;
		this.start = start;
		this.end = end;
		this.professorId = professorId;
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

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String toString() {
		return id + " - " + name + " - " + schedule + " - " + duration + " - " + start + " - " + end + " - "
				+ professorId;
	}

}
