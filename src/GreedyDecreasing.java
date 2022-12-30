public class GreedyDecreasing{
    public static void main(String args[]){
        System.out.println("Starting greedy-decreasing algorithm");
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
        Folder[] Folders = parserData.getSerialQueue();
        Folders = Sort.sortIntoPriorityQueue(Folders);
        Greedy.GreedyAlgorithm(Folders);
    }
}