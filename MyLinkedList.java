import java.lang.IllegalArgumentException;

public class MyLinkedList{
  private int size;
  private Node start,end;  

  public MyLinkedList(){
    size = 0;
    start = null;
    end = null;
  }
  
  public int size(){
    return size;
  }
  
  public boolean add(String value){
    Node node = new Node(value);
    if (size == 0){
      start = end = node;
    }
    else {
      end.getNext().setPrev(end);
      end.setNext(node);
      end = node;
    }
    size++;
    return true;
  }
  
  public void add(int index, String value){
    if (index > size){
      throw new IndexOutOfBoundsException();
    }
    Node node = new Node(value);
    Node current = end;
    int move = size;
    if (size == index){
      end.getNext().setPrev(end);
      end.setNext(node);
      end = node;
    }
    else if (index == 0) {
      node.setNext(start);
      start.setPrev(node);
      start = node;
    }
    else {
    while (move >= index){
      current.setNext(current);
      current = current.getPrev();
      current.setPrev(current.getPrev());
      if (move == index){
        current.setNext(current);
        Node previous = current.getPrev();
        current = node;
        current.setPrev(previous);  
      }
      move--;
    }
  }
    size++;
  }
  
  public String get(int index){
    if (index > size){
      throw new IndexOutOfBoundsException();
    }
    int move = index;
    Node current = start;
    while (move >= 0){
      current = current.getNext();
      move--;
    }
    return current.getData();
  }
  
  public String set(int index, String value){
    if (index > size){
      throw new IndexOutOfBoundsException();
    }
    Node node = new Node(value);
    int move = index;
    Node current = start;
    while (move != 0){
      current = current.getNext();
      move--;
    }
    current.setData(value);
    size++;
    return current.getData();
  }
  
  public String toString(){
    String listString = "[";
    Node current = start;
    if (size == 0){
      return "[]";
    }
    listString += current.getData();
    while (current.getNext() != null){
      current = current.getNext();
      listString += ", " + current.getData();
    }
    return listString + "]";
  }

  public String toStringReversed(){
    String listString = "[";
    Node current = end;
    if (size == 0){
      return "[]";
    }
    listString += current.getData();
    while (current.getPrev() != null){
      current = current.getPrev();
      listString += ", " + current.getData();
    }
    return listString + "]";
  }
  
  public String remove(int index){
    if (index > size){
      throw new IndexOutOfBoundsException();
    }
    int move = index;
    Node current = null;
    if (size == 1){
      start = end = null;
    }
    else if (index == 0){
      current = start;
      start = start.getNext();
      start.setPrev(null);
    }
    
    else if (size - 1 == index ){
      current = end;
      end = end.getPrev();
      end.setNext(null);
    }
    else {
      while (move != 0){
        current = current.getNext();
        move--;
      }
      current.getPrev().setNext(current.getNext());
      current.getNext().setPrev(current.getPrev());
    }
    size--;
    String removed = current.getData();
    return removed;  
  }
  
  public int getSize(){
    return size;
  }
  
  public void extend(MyLinkedList other){
    for (int i = 0; i < other.getSize(); i++){
      String removed = other.get(i);
      other.remove(i);
      add(removed);
    }
  }
}