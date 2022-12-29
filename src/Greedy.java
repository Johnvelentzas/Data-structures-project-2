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
        QueueImpl<Disk> Disks = new QueueImpl<Disk>();
        QueueImpl<Folder> Folders = parserData.getSerialQueue();
        int totalFolders = Folders.size();
        Folder tempFolder;
        Node<Disk> tempNode;
        boolean addedFolder;
        while (!Folders.isEmpty()) {
            addedFolder = false;
            tempFolder = Folders.get();
            System.out.println("Storing " + tempFolder.toString());
            tempNode = Disks.head;
            while (tempNode != null) {
                if(tempNode.getItem().addFolder(tempFolder)){
                    addedFolder = true;
                    break;
                }
                tempNode = tempNode.getNext();
            }
            if (addedFolder) {
                continue;
            }
            Disk newDisk = new Disk();
            newDisk.addFolder(tempFolder);
            Disks.put(newDisk);
        }
        System.out.println("The algorithm used " + Disks.size() + " disks to store " + totalFolders + " folders.");
        if (totalFolders < 100) {
            Disks.printQueue(System.out);
        }
    }
}