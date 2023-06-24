package HW_sem_3;

public class main_HW_3 {
    public static void main(String[] args) {
       LinkedList list = createList(10,100);
       System.out.println("До сортировки: ");
       list.print();
       list.revert();

       //System.out.println("После сортировки: " + list.getSize());
       list.print();      
    }    

    /**
     * Функция создает односвязный список чисел в случайном порядке по заданным параметрам:
     * @param size размер списка.
     * @param num промежуток выбора случайных числе от нуля до num
     * @return возвращает односвязный список LinkedList.
     */
    public static LinkedList createList (int size, int num){
        LinkedList l = new LinkedList();       
        for (int i = 0; i < size; i++) {
            int a = (int)(Math.random()*num);
            l.add(a);
        }        
        return l;    
    }    
}
  