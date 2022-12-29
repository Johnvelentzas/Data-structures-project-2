/**
 * This class contains an algorithm that places incoming folders into disks.
 * for every new folder if there's at least one disk with enough space to store it
 * it stores it in the disk with the most free space.
 * else it creates a new disk.
 */

public class Greedy{
    public static void main(String[] args) {
        /*
         * Creates a parser and extracts the data from the txt file.
         * If the parser can't extract the data it returns closing the main method;
         */
        foldersTXTparser parserData;
        try {
            parserData = new foldersTXTparser("folders.txt");
        } catch (Exception e) {
            return;
        }
        QueueImpl<Disk> Disks = new QueueImpl<Disk>();
        QueueImpl<Folder> Folders = parserData.getSerialQueue();
        Folder tempFolder;
        Node<Disk> tempNode;
        while (!Folders.isEmpty()) {
            tempFolder = Folders.get();
            tempNode = Disks.head;
            while (tempNode != null) {
                if(tempNode.getItem().addFolder(tempFolder)){
                    continue;
                }
                tempNode = tempNode.getNext();
            }
            Disk newDisk = new Disk();
            newDisk.addFolder(tempFolder);
            Disks.put(newDisk);
        }
    }
}