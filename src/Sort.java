public class Sort {
    public static Folder[] sortIntoPriorityQueue(Folder[] folders){
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
    return folders;
    }
}
