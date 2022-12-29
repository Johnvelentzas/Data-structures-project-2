public class Disk implements Comparable<Disk>{

    private static int totalDisks = 0;
    private int serialNum;
    private int totalDiskSpace;
    private int leftDiskSpace;
    private int usedSpace;

    private QueueImpl<Folder> foldersQueue = new QueueImpl<Folder>();
    
    /**
    *Basic constructor.
    *Creates an empty disk with 1000000 space.
    */
    Disk(){
        this.serialNum = totalDisks;
        totalDisks ++;
        this.totalDiskSpace = 1000000;
        this.leftDiskSpace = 1000000;
        this.usedSpace = 0;
    }


    /**
    *Some basic getters.
    */
    public int getLeftDiskSpace(){
        return this.leftDiskSpace;
    }

    public int getUsedSpace(){
        return this.usedSpace;
    }

    public int getTotalDiskSpace(){
        return this.totalDiskSpace;
    }

    public int getSerialNum(){
        return this.serialNum;
    }


    /**
    *Adds a folder to the folders stack.
    *@param folder the folder to be added.
    *@return true if added sucesfully.
    *@return false if it couldn't add the folder.
    */
    public boolean addFolder(Folder folder){
        if (this.leftDiskSpace < folder.getSize()) {
            return false;
        }
        this.addFolderForce(folder);
        return true;
    }


    /**
    *Forcefully adds a folder even if theres no available space.
    *Only used by own class.
    *May cause unexpected results.
    *Does not check for errors.
    *@param folder the folder to be added.
    */
    private void addFolderForce(Folder folder){
        this.leftDiskSpace -= folder.getSize();
        this.usedSpace += folder.getSize();
        this.foldersQueue.put(folder);
    }


    /**
    *@param secondDisk is a disk to be compared to this.
    *@return 1 if this disks available space is more than the second disks available space.
    *-1 if it's less.
    *0 if they're equal.
    */
    @Override
    public int compareTo(Disk secondDisk) {
        if(this.leftDiskSpace > secondDisk.getLeftDiskSpace()){
            return 1;
        }else if(this.leftDiskSpace < secondDisk.getLeftDiskSpace()){
            return -1;
        }else{
            return 0;
        }
    }

    /**
    *@return string representation of the object.
    *e.x.   (
            Disk id: 5. Space left on disk: 24030, folders:
            Folder id: 3. Size: 1900.
            Folder id: 8. Size: 2300.
            Folder id: 14. Size: 120040.
            )
    */
    @Override
    public String toString() {
        return "Disk id: " + this.serialNum + ". Space left on disk: " + this.leftDiskSpace + ", folders:\n" + this.foldersQueue.toString();
    }

}