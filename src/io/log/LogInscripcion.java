package io.log;

public class LogInscripcion {

	private int alumno;
	private int curso;
	private Accion accion;

	public LogInscripcion(int alumno2, int curso2, Accion accion) {
		alumno = alumno2;
		curso = curso2;
		this.accion = accion;
	}

	public int getAlumno() {
		return alumno;
	}

	public void setAlumno(int alumno) {
		this.alumno = alumno;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public Accion getAccion() {
		return accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	public String toString() {
		return String.format("%s %s %s", alumno, curso, accion);
	}

}
