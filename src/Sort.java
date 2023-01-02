public class Sort {
    public static Folder[] sortIntoPriorityQueue(Folder[] folders){
        long time0 = System.currentTimeMillis();
        Folder temp;
        for (int i = 0; i < folders.length - 1; i++) {
            for (int j = i + 1; j < folders.length; j++) {
                if (folders[j].compareTo(folders[i]) == 1) {
                    temp = folders[i];
                    folders[i] = folders[j];
                    folders[j] = temp;
                }
            }
        }
        long time1 = System.currentTimeMillis();
        System.out.println("Sorted array in " + (time1 - time0) + " miliseconds.");
    return folders;
    }
}
