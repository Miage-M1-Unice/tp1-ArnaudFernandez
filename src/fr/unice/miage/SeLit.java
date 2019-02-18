package fr.unice.miage;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SeLit {

    // Lecture du ficher et retire les lignes de commentaires
    static void lecture(Scanner source) {
        while(source.hasNextLine()) {
            String s = source.nextLine();
            if(!regardeSiCommentaire(s)){
                System.out.println("LU: "+s);
            }
        }
    }

    static void ecriture() throws IOException {
        FileWriter fw = new FileWriter("roger.txt");
        PrintWriter pw = new PrintWriter("./roger.txt");

        Scanner sc = new Scanner(System.in);

    }

    // Renvoie vrai si la ligne commence par //, sinon renvoi faux
    private static boolean regardeSiCommentaire(String s){
        String regex = "//.*";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(s);

        return m.matches();
    }

    static public void main(String[] args) throws IOException {

        System.out.println("Question 2.a)");
        lecture(new Scanner(new File("./roger.txt")));

        System.out.println("\nQuestion 2.b)");
        System.out.println("Ajouter une ligne au fichier roger.txt : ");
        //ecriture();
        System.out.println("\n On vérifie si ça a marché ? \n");
        lecture(new Scanner(new File("./roger.txt")));
    }
}