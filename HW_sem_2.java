/*
 * Реализовать алгоритм пирамидальной сортировки (сортировка кучей).
*/
import java.util.Arrays;

public class HW_sem_2 {

    public static void main(String[] args) {
        int[] array = CreateArray(20,100);
        
        System.out.println("Первоначальный массив: " + Arrays.toString(array));        
        SortHeap(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));

    }

    /**
     * @param size - размер массива. 
     * @param num - число в рамках которого делается случайный отбор от 0 до num.
     * @return - функция создает и заполняет массив случайных целых чисел.
     */
    public static int[] CreateArray (int size, int num){
            int[] array  = new int [size];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int)(Math.random()*num);
            }
            
            return array;
    }

    public static void SortHeap(int[] array) {
         // Построение кучи (перегруппируем массив)
        int n =  array.length;
        for (int i = n / 2 - 1; i >= 0; i--)
        heapify(array, n, i);

        // Один за другим извлекаем элементы из кучи   
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);           
        }
    }    
               
    /**
     * Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является индексом в array
     * @param array - массив
     * @param n - размер кучи
     * @param i - коревой узел
     */
    public static void heapify(int array[], int n, int i){
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2*i + 1; // левый
        int right = 2*i + 2; // правый

        // Если левый дочерний элемент больше корня
        if (left < n && array[left] > array[largest])
            largest = left;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < n && array[right] > array[largest])
            largest = right;
        // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

        // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, n, largest);
            
        }
    }       
    
    
}
