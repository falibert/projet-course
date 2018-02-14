package processing;

import business.Coureur;
import business.Course;
import service.Traitement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws ParseException {

		List<Course> courses = new ArrayList<>();	
		Course course1 = new Course("Saint�-Lyon", Traitement.convertStringToDate("03/12/2014"), 72000);
		Course course2 = new Course("Lyon Urban Trail", Traitement.convertStringToDate("16/02/2015"), 20000);
		Course course3 = new Course("Frappadingue", Traitement.convertStringToDate("18/06/2016"), 15000);
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		List<Coureur> coureurs = new ArrayList<>();
		Coureur coureur1 = new Coureur("Flo", "123456", "alibert", "florian", "Homme", 1000, 40);
		coureur1.addCourse(course1);
		coureur1.addCourse(course2);
		coureur1.addCourse(course3);
		Coureur coureur2 = new Coureur("Van", "654321", "hey", "vanesta", "Femme", 800, 35);

		Traitement.inscriptionJoueur(coureur1);
		
	}

}
