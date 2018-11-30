public class LinkedLargeInteger<T> implements LargeInteger<T>{
    private Node<Integer> head;
    private Node<Integer> tail;

    private static class Node<Integer>{
        private Integer data;
        private Node<Integer> next;

        public Node(Integer data, Node<Integer> next) {
            this.data = data;
            this.next = next;
        }
        public Node(Integer data){
            this(data, null);
        }
        public Node() {
            this(null, null);
        }
    }

    public LinkedLargeInteger(String string){
        this.head = new Node<Integer>(); 
        tail = head;
        char[] charArray = string.toCharArray();
        for (int i = 0; i < string.length(); i++){
            Integer x = Character.getNumericValue(charArray[i]);
            this.addElement(x);
        }
    }


    private boolean addElement(Integer data){
        head.next = new Node<Integer>(data, head.next);
        if (head == tail) tail = head.next;
        return true;
    }

    public int compareTo(Object data){
        return 1;
    }

    public LargeInteger add(LargeInteger input){
        return this;
    }

    public LargeInteger subtract(LargeInteger input){
        return this;
    }

    public LargeInteger multiply(LargeInteger input){
        return this;
    }

    public int hashCode(){
        return 1;
    }

    public boolean equals(LinkedLargeInteger<T> input){
        return true;
    }

    public String toString(){
        return "";
    }
}