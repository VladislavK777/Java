package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Vladislav.Klochkov on 22.06.2017.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String fileName = f.getName();
        String r = "";
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            r = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        if (r.equalsIgnoreCase("html") || r.equalsIgnoreCase("htm") || f.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
