package business;

import java.util.ArrayList;
import java.util.List;

public class Coureur {

	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private String sexe;
	private int distanceParcourueCourse;
	private int tempsCourse;
	List<Course> course = new ArrayList<>();

	public Coureur() {
		super();
	}

	public Coureur(String login, String mdp, String nom, String prenom, String sexe, int distanceParcourueCourse,
			int tempsCourse) {
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.distanceParcourueCourse = distanceParcourueCourse;
		this.tempsCourse = tempsCourse;
	}

	@Override
	public String toString() {
		return "Login coureur = " + login + "\n" + "Mot de passe = " + mdp + "\n" + "Nom = " + nom + "\n" + "Prenom = "
				+ prenom + "\n" + "Sexe = " + sexe + "\n" + "Distance parcourue course = " + distanceParcourueCourse
				+ "\n" + "Temps de course = " + tempsCourse + "\n" + "Course = " + course + "\n";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getDistanceParcourueCourse() {
		return distanceParcourueCourse;
	}

	public void setDistanceParcourueCourse(int distanceParcourueCourse) {
		this.distanceParcourueCourse = distanceParcourueCourse;
	}

	public int getTempsCourse() {
		return tempsCourse;
	}

	public void setTempsCourse(int tempsCourse) {
		this.tempsCourse = tempsCourse;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void addCourse(Course course) {
	   this.course.add(course);
	}
}
