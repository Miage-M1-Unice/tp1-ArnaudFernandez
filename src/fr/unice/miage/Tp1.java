package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Tp1 {

    public static void main(String[] args) {

        File file = new File(".");
        Filtre filtre = new Filtre();

        Tp1 exo2 = new Tp1();
        Tp1 exo3 = new Tp1();


        //System.out.println("QUESTION 2 : ");
        //exo2.displayDirectory(file);

        System.out.print("\n\n\n\n");

        System.out.println("QUESTION 3 : (le filtre est .class)");
        exo3.displayDirectoryWithFilterInOtherFile(file, ".class", 0);

    }

    private void displayDirectory(File file)
    {
        System.out.println("\n" + file.getName() + " : ");

        for(int i = 0; i < file.listFiles().length; i++) {
            if(file.listFiles()[i].isDirectory()){
                displayDirectory(file.listFiles()[i]);
            } else {
                System.out.print("[" + file.listFiles()[i].getName() + "], ");
            }
        }
    }

    private void displayDirectoryWithFilter(File file, String stringFiltre, int ... tab){
        Filtre filtre = new Filtre();

        System.out.println();

        for(int j = 0; j < tab[0]; j++){
            System.out.print('\t');
        }
        System.out.println(file.getName() + " : ");
        for(int j = 0; j < tab[0]; j++){
            System.out.print('\t');
        }
        for(int i = 0; i < file.listFiles().length; i++) {
            if(file.listFiles()[i].isDirectory()){
                displayDirectoryWithFilter(file.listFiles()[i], stringFiltre, tab[0]++);
            } else {
                if(filtre.accept(file.listFiles()[i], stringFiltre)){
                    System.out.print("[" + file.listFiles()[i].getName() + "], ");
                }
            }
        }
    }

    private void displayDirectoryWithFilterInOtherFile(File file, String stringFiltre, int ... tab){
        Filtre filtre = new Filtre();

        System.out.println();

        for(int j = 0; j < tab[0]; j++){
            System.out.print('\t');
        }
        System.out.println(file.getName() + " : ");
        for(int j = 0; j < tab[0]; j++){
            System.out.print('\t');
        }
        for(int i = 0; i < file.listFiles(filtre).length; i++) {
            if(file.listFiles()[i].isDirectory()){
                displayDirectoryWithFilter(file.listFiles()[i], stringFiltre, tab[0]++);
            } else {
                    System.out.print("[" + file.listFiles()[i].getName() + "], ");
            }
        }
    }

}
