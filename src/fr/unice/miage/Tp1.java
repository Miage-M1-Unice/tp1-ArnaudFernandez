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
        Tp1 exo3bis = new Tp1();


        //System.out.println("QUESTION 2 : ");
        //exo2.displayDirectory(file);

        System.out.print("\n\n\n\n");

        System.out.println("QUESTION 3 : (le filtre est .class / la classe est dans un autre fichier)");
        exo3.displayDirectoryWithFilterInOtherFile(file, 0);

        System.out.print("\n\n\n\n");

        System.out.println("QUESTION 3bis : (le filtre est xml / la classe est dans le fichier)");
        exo3bis.displayDirectoryWithFilterInThisFile(file, 0);

        System.out.print("\n\n\n\n");

        System.out.println("QUESTION 3ter : (le filtre est xml / la classe est dans la méthode)");
        exo3bis.displayDirectoryWithFilterInMethod(file, 0);

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

    private void displayDirectoryWithFilterInOtherFile(File file, int ... tab){
        Filtre filtre = new Filtre();

        System.out.println();

        for(int j = 0; j < tab[0]; j++){
            System.out.print('\t');
        }
        System.out.println(file.getName() + " : ");
        for(int j = 0; j < tab[0]; j++){
            System.out.print('\t');
        }


        for(File elt : file.listFiles()) {
            if(elt.isDirectory()){
                for(String filename : elt.list(filtre)){
                    System.out.print("[" + filename + "], ");
                }
                displayDirectoryWithFilterInOtherFile(elt, tab[0]++);
            }
        }
    }


    private void displayDirectoryWithFilterInThisFile(File file, int ... tab){
        FiltreInFile filtre = new FiltreInFile();

        System.out.println();

        for(int j = 0; j < tab[0]; j++){
            System.out.print('\t');
        }
        System.out.println(file.getName() + " : ");
        for(int j = 0; j < tab[0]; j++){
            System.out.print('\t');
        }

        for(File elt : file.listFiles()) {
            if(elt.isDirectory()){
                for(String filename : elt.list(filtre)){
                    System.out.print("[" + filename + "], ");
                }
                displayDirectoryWithFilterInThisFile(elt, tab[0]++);
            }
        }
    }

    private void displayDirectoryWithFilterInMethod(File file, int ... tab){
        FilenameFilter filtre = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String str = "xml";
                return name.endsWith(str);
            }
        };

        System.out.println();

        for(int j = 0; j < tab[0]; j++){
            System.out.print('\t');
        }
        System.out.println(file.getName() + " : ");
        for(int j = 0; j < tab[0]; j++){
            System.out.print('\t');
        }

        for(File elt : file.listFiles()) {
            if(elt.isDirectory()){
                for(String filename : elt.list(filtre)){
                    System.out.print("[" + filename + "], ");
                }
                displayDirectoryWithFilterInMethod(elt, tab[0]++);
            }
        }
    }
}

class FiltreInFile implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        String str = "xml";
        return name.endsWith(str);
    }
}
