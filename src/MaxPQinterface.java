public interface MaxPQinterface<T> {

    /**
     * Inserts an object into the priority queue.
     * @param object the object to insert.
     */
    public void insert(T object);


    /**
     * @return The object with the highest priority.
     */
    public T getMax();
}
