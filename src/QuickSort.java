public class QuickSort<T extends Comparable<T>> {


    public void sort(T[] list){
        sortAlgorithm(list, 0, list.length);
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
            while (list[++x].compareTo(obj) <= 0){if(x == b){break;}}
            while (list[--y].compareTo(obj) > 0) {if (y == a) {break;}}
            if(x >= y){
                break;
            }
            swap(list, x, y);
        }
        swap(list, x, b);
        return x;
    }

    private void swap(T[] list, int a, int b){
        T temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
