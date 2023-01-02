import java.io.FileWriter;
import java.io.IOException;

public class controller {
    public static void main(String args[]){
        final int numberOfFiles = 20;
        // The file the results will be put in.
        final String outputFile = "presentation\\Results.txt";
        // Where to find the input data files.
        final String filePrefix = "data\\folders";
        FileCreator.createWriteTXTfilesMulti(filePrefix, 100, numberOfFiles);
        FileCreator.createWriteTXTfilesMulti(filePrefix, 300, numberOfFiles);
        FileCreator.createWriteTXTfilesMulti(filePrefix, 500, numberOfFiles);
        FileCreator.createWriteTXTfilesMulti(filePrefix, 700, numberOfFiles);
        FileCreator.createWriteTXTfilesMulti(filePrefix, 900, numberOfFiles);
        FileCreator.createWriteTXTfilesMulti(filePrefix, 1100, numberOfFiles);
        FileCreator.createWriteTXTfilesMulti(filePrefix, 1300, numberOfFiles);
        FileCreator.createWriteTXTfilesMulti(filePrefix, 1500, numberOfFiles);
        FileCreator.createWriteTXTfilesMulti(filePrefix, 1700, numberOfFiles);
        FileCreator.createWriteTXTfilesMulti(filePrefix, 1900, numberOfFiles);
        FileCreator.createTXTfile(outputFile);
        try {
            FileWriter writer = new FileWriter(outputFile);
            compareAlgorithms(filePrefix, numberOfFiles, 100, writer);
            compareAlgorithms(filePrefix, numberOfFiles, 300, writer);
            compareAlgorithms(filePrefix, numberOfFiles, 500, writer);
            compareAlgorithms(filePrefix, numberOfFiles, 700, writer);
            compareAlgorithms(filePrefix, numberOfFiles, 900, writer);
            compareAlgorithms(filePrefix, numberOfFiles, 1100, writer);
            compareAlgorithms(filePrefix, numberOfFiles, 1300, writer);
            compareAlgorithms(filePrefix, numberOfFiles, 1500, writer);
            compareAlgorithms(filePrefix, numberOfFiles, 1700, writer);
            compareAlgorithms(filePrefix, numberOfFiles, 1900, writer);
            writer.close();
        } catch (IOException e) {
            //If any error occurs
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
    }


    /**
     * This method compares the two algorithms. The {@link Greedy greedy algorithm}, and {@link GreedyDecreasing greedy decreasing algorithm}.
     * It runs the two algorithms on the same group of {@code TXT} files with a given number of {@code Folders}.
     * It counts the total number of {@code Disks} each algorithm used for all the files.
     * It finds the average by deviding with the number of files.
     * Then it prints the results and also writes them in the output file.
     * @param filePrefix The standard file prefix includes the path and the common name to the data {@code TXT} files.
     * @param numberOfFiles The number of files to open.
     * @param numberOfFolders The number of {@code Folders} each file has.
     * @param writer The {@code FileWriter} object that will write the data into a {@code TXT} file.
     * @throws IOException If an I/O error occurs.
     */
    private static void compareAlgorithms(String filePrefix, int numberOfFiles, int numberOfFolders, FileWriter writer) throws IOException{
        int disksUsedGreedy = 0;
        int disksUsedDecreasing = 0;
        String file;
        for (int i = 0; i < numberOfFiles; i++) {
            file = filePrefix + numberOfFolders +"-" + i + ".txt";
            disksUsedGreedy += Greedy.runGreedyAlgorithmOnFile(file, false);
            disksUsedDecreasing += GreedyDecreasing.runGreedyDecreasingAlgorithmOnFile(file, false);
        }
        float averageDisksGreedy = (float)disksUsedGreedy / numberOfFiles;
        float averageDisksGreedyDecreasing = (float)disksUsedDecreasing / numberOfFiles;
        float diference = averageDisksGreedy - averageDisksGreedyDecreasing;
        System.out.println("The greedy algorithm use on average " + averageDisksGreedy + " disks for " + numberOfFolders + " folders while the greedy decreasing algorithm used " + averageDisksGreedyDecreasing + " disks.\nThe greedy algorithm used on average " + diference + " more disks.");
        writer.write("The greedy algorithm use on average " + averageDisksGreedy + " disks for " + numberOfFolders + " folders while the greedy decreasing algorithm used " + averageDisksGreedyDecreasing + " disks.\nThe greedy algorithm used on average " + diference + " more disks.\n");
    }
}
