import java.util.Comparator;

public class FolderComparator implements Comparator<Folder> {
    @Override
    public int compare(Folder t1, Folder t2) {
        return t1.compareTo(t2);
    }
}
