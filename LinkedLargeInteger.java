public class LinkedLargeInteger<T> implements LargeInteger<T>{
    private Node<Integer> head;
    private Node<Integer> tail;
    private int size = 0;

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
            size++;
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

    public LinkedLargeInteger<T> add(LinkedLargeInteger<T> argument){
        LinkedLargeInteger<T> output = new LinkedLargeInteger<T>();
        Node<Integer> current = this.head.next;
        Node<Integer> currentArg = argument.head.next;
        int sum = 0;
        int carry = 0;
        while(current != null || currentArg != null){
            sum = (current.data + currentArg.data + carry) % 10;
            carry = (current.data + currentArg.data + carry) / 10;
            output.addElement(sum);
            current = current.next;
            currentArg = currentArg.next;
        }
        return output;
    }

    public LinkedLargeInteger<T> subtract(LinkedLargeInteger<T> argument){
        /*
        LinkedLargeInteger<T> output = new LinkedLargeInteger<>();
        Node<Integer> current = this.head.next;
        Node<Integer> currentArg = argument.head.next;
        int difference, borrow = 0;
        while(current != null || currentArg != null){
            difference = current.data - currentArg.data - borrow;
            if(difference < 10){
                borrow = 1;
                difference += 10;
            } else {
                borrow = 0;
            }
            output.addElement(difference);
        }
        return output;
        */
        return this;
    }

    public LinkedLargeInteger<T> multiply(LinkedLargeInteger<T> input){
        return this;
    }

    public int hashCode(){
        int hash = 13;
        Node<Integer> current = head.next;
        while (current != null){
            hash = 23 * hash + current.data.hashCode();
            current = current.next;
        }
        return hash;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        @SuppressWarnings("unchecked")
        LinkedLargeInteger<T> list = (LinkedLargeInteger<T>) obj;
        if (size != list.size) return false;
        Node<Integer> current = head.next;
        Node<Integer> currentArg = list.head.next;
        while(current != null){
            if(!current.data.equals(currentArg.data))
                return false;
            current = current.next;
            currentArg = currentArg.next;
        }
        return true;
    }

    public String toString(){
        StringBuilder endString = new StringBuilder("]");
        Node<Integer> current = head.next;
        while (current.next != null){
            endString.append(current.data);
            current = current.next;
        }
        endString.append(current.data +"[\n");
        return endString.reverse().toString();
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
        //System.out.println(newString.subtract(newString2));
        System.out.println(newString.equals(newString2));

    }
}