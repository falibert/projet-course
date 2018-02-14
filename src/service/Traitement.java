package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import business.Coureur;
import business.Course;

public class Traitement {
    static List<Coureur> coureurs = new ArrayList<>();
    Coureur coureur1 = new Coureur("Flo", "123456", "alibert", "florian", "Homme", 1000, 40);
    Coureur coureur2 = new Coureur("Van", "654321", "hey", "vanesta", "Femme", 800, 35);
	private static Scanner sc = new Scanner(System.in);

	public static void inscriptionJoueur(Coureur a) {

		System.out.println("-------------Bienvenue sur l'processing Tapis de Course-------------" + "\n");
		int b = 0;
		String verifCompte = "";

		do {
			System.out.print("Avez-vous un compte utilisateur ? O/N : ");
			verifCompte = sc.nextLine();
			verifCompte = verifCompte.toUpperCase();
			switch (verifCompte) {
			case "N":
				a = creerCompte();
				break;
			case "O":
				do {
					try {
						System.out.println("Entrez vos identifiants : ");
						System.out.print("Login : ");
						String login = sc.nextLine();
						System.out.print("Mot de passe : ");
						String mdp = sc.nextLine();
						if (login.equalsIgnoreCase(a.getLogin()) && mdp.equalsIgnoreCase(a.getMdp())) {
							System.out.println("Connexion réussie");
							menuPrincipal(a);
							b = 1;
						} else {
							throw new Exception();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} while (b != 1);
				break;
			case "Exit":
				System.out.println("Aurevoir et à bientôt sur le programme Tapis de course");
				break;
			default:
				System.out.println("Réponse non valide");
			}
		} while (!verifCompte.equals("Exit"));
	}

	public static Coureur creerCompte() {
		System.out.print("Entrez votre Login : ");
		String s1 = sc.nextLine();
		System.out.print("Entrez votre mot de passe : ");
		String s2 = sc.nextLine();
		System.out.print("Entrez votre nom : ");
		String s3 = sc.nextLine();
		System.out.print("Entrez votre prénom : ");
		String s4 = sc.nextLine();
		System.out.print("Sexe : ");
		String s5 = sc.nextLine();
		System.out.print("Distance parcourue : ");
		int s6 = sc.nextInt();
		System.out.print("Temps de course : ");
		int s7 = sc.nextInt();

		return new Coureur(s1, s2, s3, s4, s5, s6, s7);
	}

	public static void menuPrincipal(Coureur a) {
		String s = "";

			do {	
				System.out.println("1 - Voir toutes les courses");
				System.out.println("2 - Ajouter un coureur");
				System.out.println("3 - Ajouter une course");
				System.out.println("4 - Lister les 3 meilleurs coureurs");
				System.out.println("5 - Obtenir la vitesse moyenne de chaque coureur");
				System.out.println("6 - Lister le nombre de courses réparties par mois");
			
                    System.out.println("Choisissez une option : ");
                    s = sc.nextLine();
                    if (s.equalsIgnoreCase("1")) {
                        voirListeCourse(a);
                    } else if (s.equalsIgnoreCase("2")) {
                        creerCoureur();
                    }else if(s.equalsIgnoreCase("3")){
                        creeCourse();
                    } else if (s.equalsIgnoreCase("4")) {
                        meilleurCoureur(coureurs);
                    } else if (s.equalsIgnoreCase("5")) {
                        vitesseMoyenne(a);
                    } else {
                        System.out.println("Saisie non comprise");
                    }
		} while (!(s.equalsIgnoreCase("1") || s.equalsIgnoreCase("2") || s.equalsIgnoreCase("3")));
	}

	public static void voirListeCourse(Coureur a) {
		for (int i = 0; i < a.getCourse().size(); i++) {
			System.out.println(a.getCourse().get(i));
		}
		// ou un for (Course course : a.getCourse())
		// System.out.println(course.toString());
	}

	public static void voirListeCoureur(Course a) {
		for (Coureur coureur : a.getCoureurs()) {
			System.out.println(coureur.toString());
		}
	}

	public static String recupererValeurEntree(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}

	public static Coureur creerCoureur() {
		String login = recupererValeurEntree("Entrer votre login :");
		String mdp = recupererValeurEntree("Entrer votre mot de passe :");
		String nom = recupererValeurEntree("Entrer votre nom : ");
		String prenom = recupererValeurEntree("Entrer votre prénom :");
		String sexe = recupererValeurEntree("Quel est votre sexe ? Homme, Femme");
		int distance = Integer.valueOf(recupererValeurEntree("Quelle distance avait vous parcourue sur la course ? "));
		int temps = Integer.valueOf(recupererValeurEntree("Quel temps avait vous sur la course ?"));
		return new Coureur(login, mdp, nom, prenom, sexe, distance, temps);
	}

	public static String formatDateToString(Date date) {
		return formatDateToString("dd/MM/yyyy HH:mm", date);
	}

	public static String formatDateToString(String string, Date date) {
		return new SimpleDateFormat(string).format(date);
	}
	
	public static Date convertStringToDate(String dateSaisie) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.parse(dateSaisie);
	}
	
	public static Course creeCourse() {
		String nom = recupererValeurEntree("Entrer le nom de la course :");
		Date date = null;
		try {
			date = convertStringToDate(recupererValeurEntree("Entrer la date de la course au format (dd-MM-yyyy) :"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int distance = Integer.valueOf(recupererValeurEntree("Quelle est la distance de la course"));
		return new Course(nom, date, distance);
	}

	public static Coureur meilleurCoureur(List<Coureur> listeDeCoureurs) {
		Coureur toReturn = listeDeCoureurs.get(0);
		int temps = listeDeCoureurs.get(0).getTempsCourse();
		
		for (Coureur c : listeDeCoureurs) {
			if (c.getTempsCourse() < temps) {
				temps = c.getTempsCourse();
				toReturn = c;
			}
		}
		return toReturn;
	}
	
	public static Coureur vitesseMoyenne(Coureur a) {
		
		return a;
	}

	public static Course nbreCourseMois(Course a) {
		
		return a;
	}

}
