package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {

	private String nomCourse;
	private Date date;
	private int distance;
	List<Coureur> coureurs = new ArrayList<>();

	public Course() {
	}

	public Course(String nomCourse, Date date, int distance) {
		this.nomCourse = nomCourse;
		this.date = date;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Nom de la course = " + nomCourse + "\n" + "Date = " + date + "\n" + "Distance = " + distance + " mètres"
				+ "\n";
	}

	public String getNomCourse() {
		return nomCourse;
	}

	public void setNomCourse(String nomCourse) {
		this.nomCourse = nomCourse;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<Coureur> getCoureurs() {
		return coureurs;
	}

	public void setCoureurs(List<Coureur> coureurs) {
		this.coureurs = coureurs;
	}
}
