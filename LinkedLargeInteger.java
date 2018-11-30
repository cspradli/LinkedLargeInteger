public class LinkedLargeInteger<T extends Comparable<T>> extends LargeInteger<T>{
    private Node<Integer> head;
    private Node<Integer> tail;
    private static class Node<Integer>{
        private Integer data;
        private Node<Integer> next;

        public Node(Integer data, Node next) {
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
        this.addString(string);
        char[] charArray = string.toCharArray();
        for (int i = 0; i < string.length(); i++){
            Integer x = Character.getNumericValue(charArray[i]);
            this.addElement(x);
        }
    }


    private boolean addElement(Integer data){

    }
}