import java.util.Comparator;

public class FolderComparator implements Comparator<Folder>{

    @Override
    public int compare(Folder o1, Folder o2) {
        return o1.compareTo(o2);
    }
    
}
