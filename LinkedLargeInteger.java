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
    public LinkedLargeInteger(){
        this.head = new Node<Integer>();
        tail = head;
    }
    public LinkedLargeInteger(String string){
        this.head = new Node<Integer>(); 
        tail = head;
        this.stringAdd(string);
    }

    public LinkedLargeInteger(int intNum){
        this.head = new Node<Integer>();
        tail = head;
        String string = Integer.toString(intNum);
        this.stringAdd(string);
    }

    public LinkedLargeInteger(long longNum){
        this.head = new Node<Integer>();
        tail = head;
        String string = Long.toString(longNum);
        this.stringAdd(string);
    }

    private void stringAdd(String string){
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

    public LinkedLargeInteger<T> add(LinkedLargeInteger<T> input){
        LinkedLargeInteger<T> output = new LinkedLargeInteger<T>();
        Node<Integer> current = this.head.next;
        Node<Integer> currentIn= input.head.next;
        int carryOut = 0;
        int carry = 0;
        while(current != null || currentIn != null){
            carryOut = (current.data + currentIn.data + carry) % 10;
            carry = (current.data + currentIn.data + carry) / 10;
            output.addElement(carryOut);
            current = current.next;
            currentIn = currentIn.next;
        }
        return output;
    }

    public LinkedLargeInteger<T> subtract(LinkedLargeInteger<T> input){
        return this;
    }

    public LinkedLargeInteger<T> multiply(LinkedLargeInteger<T> input){
        return this;
    }

    public int hashCode(){
        return 1;
    }

    public boolean equals(LinkedLargeInteger<T> input){
        return true;
    }

    public String toString(){
        StringBuilder stringb = new StringBuilder("[");
        Node<Integer> current = head.next;
        while (current.next != null){
            stringb.append(current.data + ", ");
            current = current.next;
        }
        stringb.append(current.data +"]\n");
        return stringb.toString();
    }

    public static void main(String[] args) {
        LinkedLargeInteger<Integer> newString = new LinkedLargeInteger<>("1234");
        System.out.println(newString);
        LinkedLargeInteger<Integer> newString2 = new LinkedLargeInteger<>("1234");
        System.out.println(newString2);
        LinkedLargeInteger<Integer> newInt = new LinkedLargeInteger<>(1234);
        System.out.println(newInt);
        LinkedLargeInteger<Integer> newLong = new LinkedLargeInteger<>(1234293723907298323L);
        System.out.println(newLong);
        System.out.println(newString2.add(newString));
    }
}