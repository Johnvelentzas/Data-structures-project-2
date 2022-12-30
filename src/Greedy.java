/**
 * This class contains an algorithm that places incoming folders into disks.
 * for every new folder if there's at least one disk with enough space to store it
 * it stores it in the disk with the most free space.
 * else it creates a new disk.
 */

public class Greedy{
    public static void main(String[] args) {
        //System.out.println("Starting greedy algorithm");
        /*
         * Creates a parser and extracts the data from the txt file.
         * If the parser can't extract the data it returns closing the main method;
         */
        foldersTXTparser parserData;
        try {
            parserData = new foldersTXTparser("src\\folders.txt");
        } catch (Exception e) {
            System.out.println("Couldn't read file.");
            return;
        }
        //System.out.println("Read file.");
        QueueImpl<Folder> Folders = parserData.getSerialQueue();
        Greedy.GreedyAlgorithm(Folders);
    }

    public static void GreedyAlgorithm(QueueImpl<Folder> Folders){
        MaxPQ<Disk> Disks = new MaxPQ<Disk>(new DiskComparator());
        int totalFolders = Folders.size();
        Folder tempFolder;
        Node<Disk> tempNode;
        boolean addedFolder;
        int totalSpaceUsed = 0;
        /*
         * A while loop repeats for every folder the scanner reads.
         */
        while (!Folders.isEmpty()) {
            tempFolder = Folders.get();
            totalSpaceUsed += tempFolder.getSize();
            System.out.println("Storing " + tempFolder.toString());
            Disk maxDisk = Disks.getMax(); //Removes the Disk with the most available space from the heap.
            if(maxDisk.addFolder(tempFolder)){  //If the incoming folder fits in the disk with the most available space it puts it there.
                Disks.add(maxDisk); // It puts the disk it took out of the heap back into the heap.
                continue;
            }
            Disks.add(maxDisk); // It puts the disk it took out of the heap back into the heap.
            Disk newDisk = new Disk(); // If the incoming folder doesn't fit in the disk with the most available space it puts it in a new disk.
            newDisk.addFolder(tempFolder);
            Disks.add(newDisk);
        }
        System.out.println("The algorithm used " + Disks.getSize() + " disks to store " + totalFolders + " folders. \nTotal folder size is " + (float)totalSpaceUsed / 1000000 + " ΤΒ.");
        if (totalFolders < 100) {
            Disks.printQueue();
        }
    }
}