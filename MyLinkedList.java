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
      Node newNode = new Node(value, end, null); //adding to the end of the node
      end.setNext(newNode); //change the end
      end = newNode;
      size ++; //increase size
      return true; //successfully added
    }
    else{
      Node newNode = new Node(value, null, null);
      start = newNode;
      end = newNode;
      size ++;
      return true;
    }
  }
  public void add(int index, Integer value){
    Node before;
    Node after;
    if(size == 0){ //if adding to empty node
      add(value);
    }
    else if(index == size){ //if adding to the end
      before = getNode(index - 1);
      Node newNode = new Node(value, null, before);
      before.setNext(newNode);
      size++;
    }
    else{
      before = getNode(index - 1); //finding node before
      after = getNode(index + 1); //finding node after
      Node newNode = new Node(value, after, before);
      before.setNext(newNode);
      after.setPrevious(newNode);
      size ++;
    }
  }
  public Integer get(int index){
    Node current = start;
    for(int i = 0; i < index; i ++){
      current = current.getNext();
    }
    return current.getData();
  }
  public void set(int index, Integer value){
    Node before;
    Node after;
    if(index == 0){ //if changing the start
      after = getNode(index + 1);
      Node newNode = new Node(value, after, null);
      after.setPrevious(newNode);
      start = newNode;
    }
    else if(index == size - 1){ //if changing the last element
      before = getNode(index - 1);
      Node newNode = new Node(value, null, before);
      end = newNode;
      before.setNext(newNode);
    }
    else{
      before = getNode(index - 1);
      after = getNode(index + 1);
      Node newNode = new Node(value, before, after);
      before.setNext(newNode);
      after.setPrevious(newNode);
    }
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

  public String toString(){
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
  public Node(Integer data1, Node previous1, Node next1){
    data = data1; //setting variables
    previous1 = previous;
    next1 = next;
  }
  public Integer getData(){
    return data; //return data
  }
  public void setData(Integer data1){
    data = data1; //set data
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
    return "" + data;
  }
}
}
