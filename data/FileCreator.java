package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public static void main(String args[]){
        createWriteTXTfilesMulti("data\\folders100", 100, 20);
        createWriteTXTfilesMulti("data\\folders500", 500, 20);
        createWriteTXTfilesMulti("data\\folders1000", 1000, 20);
        createWriteTXTfilesMulti("data\\folders2000", 2000, 20);
    }

    protected static void createWriteTXTfilesMulti(String name, int folders, int files){
        for (int i = 0; i < files; i++) {
            createWriteTXTfile(name + i + ".txt", folders);
        }
    }

    protected static void createWriteTXTfile(String name, int folders){
        createTXTfile(name);
        writeTXTfile(name, folders);
    }

    protected static void createTXTfile(String name){
        try {
            File file = new File(name);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    protected static void writeTXTfile(String name, int lines){
        try {
            FileWriter writer = new FileWriter(name);
            String str = "";
            for (int i = 0; i < lines; i++) {
                str += (int)(Math.random() * 1000000) + "\n";
            }
            str = str.substring(0, str.length() - 1);
            writer.write(str);
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
    }
}
