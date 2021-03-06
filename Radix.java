import java.util.*;

public class Radix{
  
  public static int nth(int n, int col){
    int place = (int)Math.pow(10, col);
    if (place > n){
      return 0;
    }
    n = n / place;
    int nth = n % 10;
    return nth;
  }
  
  public static int length(int n){
    int col = 0;
    if (n == 0){
      return 1;
    }
    while (Math.pow(10, col) <= Math.abs(n)){
      col++;
    }
    return col;
  }
  
  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }
  
  public static int getMaximum(SortableLinkedList data){
    int max = data.get(0);
    int lengthData = data.size();
    int i = 0;
    while (i < lengthData){
      int current = data.remove(0);
      if (current > max){
        max = current;
      }
      data.add(current);
      i++;
    }
    return max;
  }
  
  public static void radixSortSimple(SortableLinkedList data){

    int max = getMaximum(data);

    //System.out.println(max + " max");
    int lengthData = data.size();
    
    //System.out.println(lengthData + " lengthData");

    for (int i = 0; i < length(max); i++){
      
      SortableLinkedList[] buckets = new SortableLinkedList[10];

      for (int k = 0; k < 10; k++){
        buckets[k] = new SortableLinkedList();
      }

    /*  for (int j = 0; j < lengthData; j++){
        int current = data.get(j);        
        int nth = nth(current, i);        
        buckets[nth].add(current);
        //System.out.println(current);
      }
      */

      while (data.size() > 0){
        int current = data.remove(0);
        int nth = nth(current, i);
        buckets[nth].add(current);
      }

      merge(data, buckets);

      // System.out.println(data);
      
    }
    //System.out.println(data + "new line"); //Debug print statement, shows that the linked list is sorted but tester says it isn't sorted.
  }

  public static void radixSort(SortableLinkedList data){
    
    int max = getMaximum(data);
    int lengthData = data.size();

    for (int i = 0; i < max; i++){
      
      SortableLinkedList[] buckets = new SortableLinkedList[10];

      for (int k = 0; k < 10; k++){
        buckets[k] = new SortableLinkedList();
      }

      while (data.size() > 0){
        int current = data.remove(0);
        int nth = nth(current, i);
        buckets[nth].add(current);
      }

      merge(data, buckets);
        
    }
  }
  
}