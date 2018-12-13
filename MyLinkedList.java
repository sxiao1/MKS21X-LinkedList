class MyLinkedList{
  private int size;
  private Node start,end;
  public MyLinkedList(int size1, Node start1, Node end1){
    size = size1; //setting variables
    start = start1;
    end = end1;
  }
  public int size(){
    return size;
  }
  public boolean add(int value){
    Node newNode = new Node(value, end, null); //adding to the end of the node
    end.setNext(newNode); //change the end
    end = newNode;
    size ++; //add size
    return true; //successfully added
  }
  public String toString(){
    Node ans = start;
    String str = "[";
    while(ans != null){
      str += ans.getData();
      ans = ans.getNext();
    }
    return str += "]";
  }
}
