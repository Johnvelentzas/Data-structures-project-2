public class SortFolders{

    public static void sort(Folder[] folders){
        QuickSort<Folder> quickSort = new QuickSort<Folder>();
        quickSort.sort(folders);
    }
}
