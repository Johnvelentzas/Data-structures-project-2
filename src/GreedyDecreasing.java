public class GreedyDecreasing{
    public static void main(String args[]){
        System.out.println("Starting greedy-decreasing algorithm");
        runGreedyDecreasingAlgorithmOnFile(args[0], true);
    }

    public static int runGreedyDecreasingAlgorithmOnFile(String pathname, boolean printResults){
        foldersTXTparser parserData = new foldersTXTparser(pathname);
        Folder[] Folders = parserData.getSerialQueue();
        Folders = Sort.sortIntoPriorityQueue(Folders);
        return Greedy.GreedyAlgorithm(Folders, printResults);
    }
}