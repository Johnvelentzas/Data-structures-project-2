public class Folder implements Comparable<Folder>{
    
    private static int totalFolders = 0;
    private int serialNum;
    private int size;


    /**
    *Basic constractor.
    *Creates a folder with random size from 0 to 1000000.
    */
    Folder(){
        this.size = (int)(Math.random() * 1000000);
        this.serialNum = totalFolders;
        totalFolders ++;
    }

    /**
    *Basic constractor.
    *Creates a folder with a given size.
    *@param size the size of the folder to be created.
    */
    Folder(int size){
        this.size = size;
        this.serialNum = totalFolders;
        totalFolders ++;
    }


    /**
    *Basic getter.
    */
    public int getSize(){
        return this.size;
    }


    /**
    *@param secondFolder is a folder to be compared to this.
    *@return 1 if this folder size is more than the second folders size.
    *@return -1 if it's less.
    *@return 0 if they're equal.
    */
    @Override
    public int compareTo(Folder secondFolder) {
        if (this.size > secondFolder.getSize()) {
            return 1;
        }else if(this.size < secondFolder.getSize()){
            return -1;
        }else{
            return 0;
        }
    }


    /**
    *@return string representation of the object.
    *e.x. (Folder id: 3. Size: 1900.)
    */
    @Override
    public String toString() {
        return "Folder id: " + this.serialNum + ". Size: " + this.size + ".";
    }

}
