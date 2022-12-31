public class Sort {
    public static Folder[] sortIntoPriorityQueue(Folder[] folders){
            for (int i = 0; i < folders.length - 1; i++) {
                for (int j = i + 1; j < folders.length; j++) {
                    if (folders[j].compareTo(folders[i]) == 1) {
                        Sort.swap(folders[j], folders[i]);
                    }
                }
            }
        return folders;
    }

    public static void swap(Object o1, Object o2){
        Object temp =o1;
        o1 = o2;
        o2 = temp;
    }
}
