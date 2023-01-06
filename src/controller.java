import java.io.FileWriter;
import java.io.IOException;

public class controller {
    public static void main(String args[]){
        final int numberOfFiles = 20;
        // The file the results will be put in.
        final String outputFile = "presentation\\Results-test.txt";
        // Where to find the input data files.
        final String filePrefix = "data\\folders-test";
        //All folder numbers to test
        final int[] numberOfFolders = {20, 50, 100};
        testData(numberOfFiles, outputFile, filePrefix, numberOfFolders);
    }

    public static void testData(int numberOfFiles, String outputFile, String filePrefix, int[] numberOfFolders){
        for (int i : numberOfFolders) {
            FileCreator.createWriteTXTfilesMulti(filePrefix, i, numberOfFiles);            
        }
        FileCreator.createTXTfile(outputFile);
        try {
            FileWriter writer = new FileWriter(outputFile);
            for (int i : numberOfFolders) {
            compareAlgorithms(filePrefix, numberOfFiles, i, writer);                
            }
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
