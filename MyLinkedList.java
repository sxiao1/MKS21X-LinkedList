public class MyLinkedList{
  private int size;
  private Node start,end;
  public MyLinkedList(){
    size = 0;
  }
  public int size(){
    return size;
  }
  public boolean add(Integer value){
    if(size > 0){
      Node newNode = new Node(value, null, end); //adding to the end of the node
      end.setNext(newNode); //change the end
      end = newNode;
      size ++; //increase size
    }
    if (size == 0){
      Node newNode = new Node(value, null, null);
      start = newNode;
      end = newNode;
      size ++;
    }
    return true;
  }
  public void add(int index, Integer value){
    if(index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    Node current = start;
    if(index == 0){ //if adding to beginning
      Node newNode = new Node(value, current, null);
      current.setPrevious(newNode);
      start = newNode;
      size++;
    }
    else {
      for(int i = 0; i < size ; i ++){
        if(i == index){
          Node newNode = new Node(value, current, current.getPrevious());
          current.getPrevious().setNext(newNode);
          current.setPrevious(newNode);
        }
        current = current.getNext();
      }
      size ++;
    }
  }
  public Integer get(int index){
    Node current = start;
    int i = 0;
    while(i < size){
      if(i == index){
        return current.getData();
      }
      i ++;
      current = current.getNext();
    }
    throw new IndexOutOfBoundsException("invalid Index");
  }
  public Integer set(int index, Integer value){
    if(index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    Node current = start;
    for(int i = 0; i < index; i ++){
      current = current.getNext();
    }
    Integer out = current.getData();
    current.setData(value);
    return out;
  }
  public boolean contains(Integer value){
    Node current = start;
    for(int i = 0; i < size; i ++){
      if(current.getData() == value){ //if current value matches with value then true
        return true;
      }
      else{
        current = current.getNext();
      }
    }
    return false; //loops but no matched value return false
  }
  public int indexOf(Integer value){
    Node current = start;
    int index = 0;
    for(int i = 0; i < size; i ++){
      if(current.getData() == value){
        return index; //return index of matched value
      }
      else{
        current = current.getNext();
        index ++; //adding index
      }
    }
    return -1; //no matched value, invalid index
  }
  public Integer remove(int index){
    if(index == 0){ //if first element
      start = start.getNext(); // shift over the start
      size --;
      return start.getData();
    }
    if(index == size - 1){ //if last element
      end = end.getPrevious(); //shift over end
      size --;
      return end.getData();
    }
    else{
      Node before;
      Node after;
      Node current;
      current = getNode(index); //store for later
      before = getNode(index - 1);
      after = getNode(index +1);
      before.setNext(after); //set one before to one after
      after.setPrevious(before); // set one after to one before
      size --;
      return current.getData();
    }
  }
  public boolean remove(Integer value){
    if(contains((int)value)){ //if value is there
      int index = indexOf(value);
      remove(index);
      return true;
    }
    return false;
  }
  public String toString(){
    if(size == 0){
      return "[]";
    }
    Node current = start;
    String str = "[";
    while(current.getNext() != null){ //stop at last element
      str += current.getData() + ", ";
      current = current.getNext();
    }
    str += current.getData() + "]"; //add last element and end
    return str;
  }
  private Node getNode(int index){
    Node current = start;
    for(int i = 0; i < index; i++){
      current = current.getNext();
    }
    return current;
  }

private class Node{
  private Integer data;
  private Node previous;
  private Node next;
  public Node(Integer data1, Node next1, Node previous1){
    data = data1; //setting variables
    previous = previous1;
    next = next1;
  }
  public Integer getData(){
    return data; //return data
  }
  public Integer setData(Integer i){
    Integer oldData = data;
    data = i; //set data
    return data;
  }
  public Node getNext(){
    return next; //return the next value
  }
  public void setNext(Node next1){
    next = next1; // set next
  }
  public Node getPrevious(){
    return previous;//return previous value
  }
  public void setPrevious(Node previous1){
    previous  = previous1; //set the previous number
  }
  public String toString(){
    String str = "";
    str += getData();
    return str;
  }
}
}
