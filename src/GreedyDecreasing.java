public class GreedyDecreasing{
    public static void main(String args[]){
        runGreedyDecreasingAlgorithmOnFile(args[0], true);
    }

    public static int runGreedyDecreasingAlgorithmOnFile(String pathname, boolean printResults){
        System.out.println("Running greedy decreasing algorithm on file " + pathname);
        long time0 = System.currentTimeMillis();
        foldersTXTparser parserData = new foldersTXTparser(pathname);
        Folder[] Folders = parserData.getSerialQueue();
        Folders = Sort.sortIntoPriorityQueue(Folders);
        int greedyResult  = Greedy.GreedyAlgorithm(Folders, printResults);
        long time1 = System.currentTimeMillis();
        System.out.println("Greedy decreasing algorithm took " + (time1 - time0) + " miliseconds.");
        return greedyResult;
    }
}