public class QuickSort<T extends Comparable<T>> {


    public void sort(T[] list){
        sortAlgorithm(list, 0, list.length - 1);
    }

    private void sortAlgorithm(T[] list, int a, int b){
        if (b <= a) {
            return;
        }
        int p = partition(list, a, b);
        sortAlgorithm(list, a, p -1);
        sortAlgorithm(list, p + 1, b);
    }

    private int partition(T[] list, int a, int b){
        int x = a - 1;
        int y = b;
        T obj = list[b];
        for(;;){
            while (list[++x].compareTo(obj) < 0){}
            while (list[--y].compareTo(obj) > 0) {if (y == a) {break;}}
            if(x >= y){
                break;
            }
            swap(list, x, y);
        }
        swap(list, x, b);
        return x;
    }


    /**
     * Swaps two objects of class {@code T} from the list {@code list}.
     * The first object is at the index a {@code list[a]} and the second is at the index b {@code list[b]}
     * @param list the list with all the class T objects.
     * @param a the index of the first object to swap.
     * @param b the index of the second object to swap.
     */
    private void swap(T[] list, int a, int b){
        T temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
