import java.util.Comparator;

public class DiskComparator implements Comparator<Disk>{

    @Override
    public int compare(Disk o1, Disk o2) {
        return o1.compareTo(o2);
    }
    
}