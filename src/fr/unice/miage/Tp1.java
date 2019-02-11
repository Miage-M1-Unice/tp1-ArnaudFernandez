package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Tp1 {

    public static void main(String[] args) {

        File file = new File(".");
        Tp1 exo2 = new Tp1();

        exo2.displayDirectory(file);

    }

    private void displayDirectory(File file)
    {
        System.out.println("\n" + file.getName() + " : ");

        for(int i = 0; i < file.listFiles().length; i++) {
            if(file.listFiles()[i].isDirectory()){
                displayDirectory(file.listFiles()[i]);
            }
            else
            {
                System.out.print("[" + file.listFiles()[i].getName() + "], ");
            }
        }
    }
}
