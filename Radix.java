import java.util.*;

public class Radix{
  
  public static int nth(int n, int col){
    int move;
    if (Math.pow(10, col) > n){
      move = length(n);
    }
    else{
      move = col;
    }
    while (move != 0){
      n = n / 10;
    }
    int nth = n % 10;
    return nth;
  }
  
  public static int length(int n){
    int col = 0;
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
    for (int i = 0; i < data.size(); i++){
      if (data.get(i) > max){
        max = data.get(i);
      }
    }
    return max;
  }
  public static void radixSortSimple(SortableLinkedList data){

    int max = getMaximum(data);
    
    for (int i = 0; i < length(max); i++){
      
      SortableLinkedList[] buckets = new SortableLinkedList[10];
      for (int j = 0; j < data.size(); j++){
        
        int current = data.get(j);
        int nth = nth(current, i);
        buckets[nth].add(current);
        
      }
      SortableLinkedList sub = new SortableLinkedList();
      merge(sub, buckets);
      data = sub;
    }
  }

  public static void radixSort(SortableLinkedList data){

    int max = getMaximum(data);
    
    for (int i = 0; i < length(max); i++){
      
      SortableLinkedList[] buckets = new SortableLinkedList[10];
      for (int j = 0; j < data.size(); j++){
        
        int current = data.get(j);
        int nth = nth(current, i);
        buckets[nth].add(current);
        
      }
      merge(data, buckets);
    }
  }
}