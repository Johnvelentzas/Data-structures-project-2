public class GreedyDecreasing{
    public static void main(String args[]){
        System.out.println("Starting greedy-decreasing algorithm");
        /*
         * Creates a parser and extracts the data from the txt file.
         * If the parser can't extract the data it returns closing the main method;
         */
        foldersTXTparser parserData;
        try {
            parserData = new foldersTXTparser("data\\folders20000.txt");
        } catch (Exception e) {
            System.out.println("Couldn't read file.");
            return;
        }
        Folder[] Folders = parserData.getSerialQueue(); //Extracts an array of folders from the txt file.
        System.out.println("Sorting Folders.");
        Folders = Sort.sortIntoPriorityQueue(Folders); //Sorts the array from biggest to smallest folder.
        Greedy.GreedyAlgorithm(Folders); //Runs the greedy algorithm.
    }
}