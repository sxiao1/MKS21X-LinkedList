class Node{
  private int data;
  private Node previous;
  private Node next;
  public Node(int data1, Node previous1, Node next1){
    data = data1; //setting variables
    previous1 = previous;
    next1 = next;
  }
  public int getData(){
    return data; //return data
  }
  public void setData(int data1){
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
}
