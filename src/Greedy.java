/**
 * This class contains an algorithm that places incoming folders into disks.
 * for every new folder if there's at least one disk with enough space to store it
 * it stores it in the disk with the most free space.
 * else it creates a new disk.
 */

public class Greedy{
    public static void main(String[] args) {
        System.out.println("Starting greedy algorithm");
        runGreedyAlgorithmOnFile(args[0], true);
    }

    public static int runGreedyAlgorithmOnFile(String pathname, boolean printResults){
        /*
         * Creates a parser and extracts the data from the txt file.
         */
        foldersTXTparser parserData = new foldersTXTparser(pathname);
        Folder[] Folders = parserData.getSerialQueue();
        return Greedy.GreedyAlgorithm(Folders, printResults);
    }


    /**
     * The greedy Algorithm.
     * <p>
     * This algirithm takes an incoming list of {@code Folder} objects and puts them in {@code Disks}.
     * It stores a priority heap {@link MaxPQ} with all the {@code Disks} it has already used.
     * The heap always outputs the disk with the most available space left with the {@link MaxPQ#getMax() getMax()} function.
     * At the beginning it creates an empty {@code Disk} that is stored in the PQ.
     * Then for each {@code Folder} if it fits inside the {@code Disk} with the most available space it stores it there.
     * Else it stores it in a new empty {@code Disk}
     * </p>
     * <p>
     * This algorithm is <b>not</b> the most effective in storing Folders in multiple Disks.
     * </p>
     * <p>
     * After the completion of the algorithm it prints its results.
     * It prints the number of disks it used to store all the folders, the number of folders it stored
     * and the total space used in terabytes by all the folders on all the disks.
     * The ideal would be that the number of disks would be the same as the total terabytes used rounded up.
     * In some cases this can be achieved by this algorithm but it' very rare.
     * The {@link GreedyDecreasing Greedy decreasing algorithm} has a higher eficiency in completing this task.
     * </p>
     * @param Folders a list of all the incoming Folders the algorithm needs to store
     * @return the number of disks used to store the all the {@code Folders}
     * @see MaxPQ
     * @see {@link Disk} the {@code Disk} class, {@link Folder} the {@code Folder} class.
     * @see GreedyDecreasing
     * @implSpec The simplyfied code is:
     * <pre>{@code  
     * MaxPQ<Disk> Disks = new MaxPQ<Disk>(new DiskComparator());
     * // Adds to the heap an empty Disk
     * Disks.add(new Disk());
     * for (Folder folder : Folders) {
     *      //Removes the Disk with the most available space from the heap.
     *      Disk maxDisk = Disks.getMax();
     *      //If the incoming folder fits in the disk with the most available space it puts it there.
     *      if(maxDisk.addFolder(folder)){ 
     *          // It puts the disk it took out of the heap back into the heap.
     *          Disks.add(maxDisk);
     *          continue;
     *      }
     *      // It puts the disk it took out of the heap back into the heap.
     *      Disks.add(maxDisk);
     *      // If the incoming folder doesn't fit in the disk with the most
     *      // available space it puts it in a new disk.
     *      Disk newDisk = new Disk();
     *      newDisk.addFolder(folder);
     *      Disks.add(newDisk);
     * }</pre>
     */
    public static int GreedyAlgorithm(Folder[] Folders, boolean printResults){
        MaxPQ<Disk> Disks = new MaxPQ<Disk>(new DiskComparator());
        int totalFolders = Folders.length;
        int totalSpaceUsed = 0;
        // Adds to the heap an empty Disk
        Disks.add(new Disk());
        /*
         * A for loop repeats for every folder the scanner reads.
         */
        for (Folder folder : Folders) {
            totalSpaceUsed += folder.getSize();
            //System.out.println("Storing " + folder.toString());
            //Removes the Disk with the most available space from the heap.
            Disk maxDisk = Disks.getMax();
            //If the incoming folder fits in the disk with the most available space it puts it there.
            if(maxDisk.addFolder(folder)){ 
                // It puts the disk it took out of the heap back into the heap.
                Disks.add(maxDisk);
                continue;
            }
            // It puts the disk it took out of the heap back into the heap.
            Disks.add(maxDisk);
            // If the incoming folder doesn't fit in the disk with the most available space it puts it in a new disk.
            Disk newDisk = new Disk();
            newDisk.addFolder(folder);
            Disks.add(newDisk);
        }
        if (printResults) {
            System.out.println("The algorithm used " + Disks.getSize() + " disks to store " + totalFolders + " folders. \nTotal folder size is " + (float)totalSpaceUsed / 1000000 + " ΤΒ.");
            if (totalFolders < 100) {
                Disks.printQueue();
            }  
        }
        
        return Disks.getSize();
    }
}