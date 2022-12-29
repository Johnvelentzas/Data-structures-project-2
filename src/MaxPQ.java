import java.util.Comparator;

/**
 * This class simply extends the HeapPriorityQueue class with intent to change some names.
 * @param <T>
 */

public class MaxPQ<T> extends HeapPriorityQueue<T> implements MaxPQinterface<T>{

    /**
     * Simple constructor.
     */
    public MaxPQ(Comparator<T> comp) {
        super(comp);
    }

    /**
     * @param object to be inserted.
     * Simply changes the name of the add function to insert to match the ecxersise.
     */
    @Override
    public void insert(T object) {
        super.add(object);
    }

}