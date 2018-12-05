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


    /**
     * 
     * Make String an Integer, add it to the front of the Linked List
     * 
     */
    private void stringAdd(String string){
        char[] charArray = string.toCharArray();
        for (int i = 0; i < string.length(); i++){
            Integer x = Character.getNumericValue(charArray[i]);
            this.addElement(x);
        }
    }


    /**
     * Add an element to the front of the Linked List
     * @param data
     * @return true if succesfull
     */
    private boolean addElement(Integer data){
        head.next = new Node<Integer>(data, head.next);
        if (head == tail) tail = head.next;
        size++;
        return true;
    }


    /**
     * Add an element to the end of the Linked List 
     * @param data
     * @return true if succesfull
     */
    private boolean addLast(Integer data){
        tail.next = new Node<Integer>(data);
        tail = tail.next;
        size++;
        return true;
    }

    /**
     * 
     * Reverse a Linked List
     * 
     */
    private void reverse(LinkedLargeInteger<T> input){
        Node<Integer> reversedPart = null;
        Node<Integer> current = input.head.next;
        while (current != null){
            Node<Integer> next = current.next;
            current.next = reversedPart;
            reversedPart = current;
            current = next;
        }
        input.head.next = reversedPart;
    }
    

    public int compareTo(Object obj){
        @SuppressWarnings("unchecked")
        Node<Integer> input = (Node<Integer>) obj;
        if (this.tail.data > input.data) return 1;
        if (this.tail.data < input.data) return -1;
        else{return 0;}
    }

    /**
     * 
     * If one LLI is less than the other, pad with zeroes to match the space
     * @param first
     * @param second
     * 
     */
    private void flushZero(LinkedLargeInteger<T> first, LinkedLargeInteger<T> second){
        int difference = 0;
        if (first.size > second.size){
            difference = first.size - second.size;
            for (int i = 0; i < difference; i++){
                second.addLast(0);
            }
        } else if (second.size > first.size)
        {
            difference = second.size - first.size;
            for (int i = 0; i < difference; i++){
                first.addLast(0);
            }
        }
    }

    public LinkedLargeInteger<T> add(LinkedLargeInteger<T> argument){
        LinkedLargeInteger<T> output = new LinkedLargeInteger<T>();
        Node<Integer> current = this.head.next;
        Node<Integer> currentArg = argument.head.next;
        int sum = 0;
        int carry = 0;
        flushZero(this, argument);
        while(current != null || currentArg != null){
            sum = (current.data + currentArg.data + carry) % 10;
            carry = (current.data + currentArg.data + carry) / 10;
            output.addElement(sum);
            current = current.next;
            currentArg = currentArg.next;
        }
        reverse(output);
        return output;
    }

    public LinkedLargeInteger<T> subtract(LinkedLargeInteger<T> argument){   
        LinkedLargeInteger<T> output = new LinkedLargeInteger<T>();
        Node<Integer> current = this.head.next;
        Node<Integer> currentArg = argument.head.next;
        int difference = 0; 
        int borrow = 0;
        flushZero(this, argument);
            while(current != null || currentArg != null){
                difference = (current.data) - (currentArg.data) - borrow;
                borrow = 0;
                if(difference < 0){
                    borrow = 1;
                    difference = difference + 10;
            } else { borrow = 0; }
                output.addElement(difference);
                current = current.next;
                currentArg = currentArg.next;
            }
        reverse(output);
        return output;
    }

    public LinkedLargeInteger<T> multiply(LinkedLargeInteger<T> argument){
        LinkedLargeInteger<T> output = new LinkedLargeInteger<T>();
        for (int i = 0; i < (this.size + argument.size + 1); i++){
            output.addElement(0);
        }
        Node<Integer> currentArg = argument.head.next;
        Node<Integer> outputNode1 = output.head.next;
        Node<Integer> outputNode2;
        Node<Integer> current;
        flushZero(this, argument);
        
        while(currentArg != null){
            int carry = 0;
            int digit;
            outputNode2 = outputNode1;
            current = this.head.next;
            while(current != null){

                digit = (current.data * currentArg.data) + carry;
                outputNode2.data += digit % 10;

                carry = (digit / 10) + (outputNode2.data/10);
                outputNode2.data = outputNode2.data % 10;

                current = current.next;
                outputNode2 = outputNode2.next;    
            }
            if(carry > 0) outputNode2.data += carry;
            outputNode1 = outputNode1.next;
            currentArg = currentArg.next;
        }
        return output;
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
        endString.reverse();
        return endString.toString();
    }

    public static void main(String[] args) {
        System.out.println("Linked Large Integers: \n\n");
        LinkedLargeInteger<Integer> newString = new LinkedLargeInteger<>("1234");
        System.out.println("String:" + newString);
        LinkedLargeInteger<Integer> newString2 = new LinkedLargeInteger<>("1234");
        LinkedLargeInteger<Integer> newInt = new LinkedLargeInteger<>(1234);
        System.out.println("Integer: " + newInt);
        LinkedLargeInteger<Integer> newLong = new LinkedLargeInteger<>(12342937239L);
        System.out.println("Long: "+newLong);
        LinkedLargeInteger<Integer> newLLI = new LinkedLargeInteger<>(237823);
        LinkedLargeInteger<Integer> newLLI2 = new LinkedLargeInteger<>(313013);
        System.out.println("----------------------------------");
        System.out.println("Addition:");
        System.out.println(newString);
        System.out.println(newString2);
        System.out.println("= " + newString.add(newString2));
        System.out.println(newLong);
        System.out.println(newInt);
        System.out.println("= " + newLong.add(newInt));
        System.out.println(newLLI2);
        System.out.println(newLLI);
        System.out.println("= " + newLLI2.add(newLLI));
        System.out.println("----------------------------------");
        System.out.println("Subtraction:");
        System.out.println(newLong);
        System.out.println(newInt);
        System.out.println("= " + newLong.subtract(newInt));
        System.out.println(newString);
        System.out.println(newString2);
        System.out.println("= " + newString.subtract(newString2));
        System.out.println(newLLI2);
        System.out.println(newLLI);
        System.out.println("= " + newLLI2.subtract(newLLI));
        System.out.println("----------------------------------");
        System.out.println("Multiply:");
        System.out.println(newString);
        System.out.println(newString2);
        System.out.println("= " + newString.multiply(newString2));
        System.out.println(newLLI2);
        System.out.println(newLLI);
        System.out.println("= " + newLLI2.multiply(newLLI));
    }
}