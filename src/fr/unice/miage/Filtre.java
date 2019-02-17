package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;

public class Filtre implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        String str = "xml";
        return name.endsWith(str);
    }
}
