import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileCreator {
    public static void main(String args[]){
        createWriteTXTfilesMulti("data\\folders", 100, 25);
        createWriteTXTfilesMulti("data\\folders", 500, 25);
        createWriteTXTfilesMulti("data\\folders", 1000, 25);
        createWriteTXTfilesMulti("data\\folders", 2000, 25);
    }

    /**
     * Creates a specified ammount of {@code TXT} files with a specified ammount of lines.
     * Each line has a random number from {@code 0} not included to {@code 1000000} included.
     * The name of the files created is the name given as a prefix followed by a {@code "-"}
     * followed by the index of the file and {@code ".txt"} dot txt.
     * If the files already exists they are modified with new data.
     * E.X. if the name given is "test" the one of the output files could be named ("test-4.txt").
     * @implSpec The index of the file is determined by a for loop:
     * <pre>{@code         
     * for (int i = 0; i < files; i++) {
     *      createWriteTXTfile(name + "-" + i + ".txt", folders);
     * }
     * }</pre>
     * @see {@link #createWriteTXTfile(String, int)}
     * @see for creating the {@code TXT} files {@link #createTXTfile(String)}
     * @see for writing on the {@code TXT} files {@link #writeTXTfile(String, int)}
     * @param name the name to be added as a prefix to the files created.
     * @param folders the number of lines to be written.
     * @param files the nimber of files to be created
     */
    public static void createWriteTXTfilesMulti(String name, int folders, int files){
        for (int i = 0; i < files; i++) {
            createWriteTXTfile(name + folders +"-" + i + ".txt", folders);
        }
    }


    /**
     * Creates a TXT file with the given name.
     * If the file already exists or the name is invalid it does not create the file.
     * Writes on the TXT file given a curtain ammount of lines.
     * If the file already exists it is modified with new data.
     * Each line it writes is a number from 0 not included to 1000000 included.
     * @param name the name to be given to the file.
     * @param folders the number of lines to be written.
     * @see for creating the {@code TXT} files {@link #createTXTfile(String)}
     * @see for writing on the {@code TXT} files {@link #writeTXTfile(String, int)}
     */
    public static void createWriteTXTfile(String name, int folders){
        createTXTfile(name);
        writeTXTfile(name, folders);
    }


    /**
     * Creates a TXT file with the given name.
     * If the file already exists or the name is invalid it does not create the file.
     * @param name the name to be given to the file.
     */
    public static void createTXTfile(String name){
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


    /**
     * Writes on the TXT file given a curtain ammount of lines.
     * If the file already exists it is modified with new data.
     * Each line it writes is a number from 0 not included to 1000000 included.
     * @param name the name of the TXT file to be written.
     * @param lines the number of lines to be written.
     */
    public static void writeTXTfile(String name, int lines){
        try {
            FileWriter writer = new FileWriter(name);
            // Creates a random number generator.
            Random randomNumberGenerator = new Random();
            // The string to be written into the file.
            String str = "";
            // Loops as many times as the parameter lines defines.
            for (int i = 0; i < lines; i++) {
                // For each line it adds a random number from (0,1000000] and a new line character at the end.
                str += (randomNumberGenerator.nextInt(1000000)) + 1 + "\n";
            }
            str = str.substring(0, str.length() - 1); // Deletes the new line character at the end of the string.
            writer.write(str); // Writes the string into yhe file.
            writer.close();
        } catch (Exception e) {
            //If any error occurs
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
    }
}
