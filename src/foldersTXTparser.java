import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class foldersTXTparser {

    File file;
    Scanner scanner;
    int numOfFolders = 0;
    int totalSpaceUsed = 0;
    QueueImpl<Folder> foldersSerial = new QueueImpl<Folder>();
    MaxPQ<Folder> foldersPriority = new MaxPQ<Folder>(new FolderComparator());

    /**
     * Basic constructor.
     * @param pathName the string represantation of the path e.x (folder/text.txt).
     * Creates a file from the path.
     * Creates a scanner that reads the file.
     * Creates a Queue and a priority Queue with the folders it read from the file given.
     * @throws Exception
     */
    foldersTXTparser(String pathName) throws Exception{
            System.out.println("Reading file " + pathName);
            //Temporary variable to store folders as they are read one by one.
            Folder tempFolder;
            //A file is created from the file path given and a scanner opens and reads the file.
            this.file = new File(pathName);
            //System.out.println("Created file.");
            try {
                this.scanner = new Scanner(this.file);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                System.exit(0);
            }
            //System.out.println("Created scanner.");
            //Reads every line of the file one by one.
            while (this.scanner.hasNextLine()) {
                //System.out.println("Reading a line");
                //Every line is turned into an integer that is used to create a file with that int size 
                //which is insered into the priority and the serial Queue.
                tempFolder = new Folder(Integer.parseInt(this.scanner.nextLine()));
                if (tempFolder.getSize() > 1000000 || tempFolder.getSize() < 0) {
                    throw new Exception("Invalid folder size");
                }
                this.totalSpaceUsed += tempFolder.getSize();
                this.foldersPriority.insert(tempFolder);
                this.foldersSerial.put(tempFolder);
            }
            this.numOfFolders = this.foldersSerial.size;
            scanner.close();
    }

    /**
     * @return Number of Folders on the file.
     */
    public int getNumOfFolders(){
        return this.numOfFolders;
    }

    /**
     * @return Total space taken by folders.
     */
    public int getTotalSpaceUsed(){
        return this.totalSpaceUsed;
    }

    /**
     * @return the next Folder from the Queue.
     * The folders are returned in the order they were in the input.
     * 
     */
    public Folder getNextFolderSerial(){
        return this.foldersSerial.get();
    }

    /**
     * @return the next Folder from the Priority Queue.
     * The folders are returned in order from largest size to smallest size.
     */
    public Folder getNextFolderPriority(){
        return this.foldersPriority.getMax();
    }


    /**
     * @return A serial Queue with the folders from the given file.
     * The folders are in the order they were in the input.
     * The folders are objects shared with the priority Queue so any change applies to both.
     */
    public QueueImpl<Folder> getSerialQueue(){
        return this.foldersSerial;
    }

    /**
     * @return A Priority Queue with the folders from the given file.
     * The folders are in order from largest size to smallest size.
     * The folders are objects shared with the serial Queue so any change applies to both.
     */
    public MaxPQ<Folder> getPriorityQueue(){
        return this.foldersPriority;
    }
}
