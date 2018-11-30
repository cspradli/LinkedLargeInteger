public interface LargeInteger<T extends Comparable<T>>{

    /**
     * 
     * Takes a LargeInteger and returns the LargeInteger sum of this and the argument.
     * @return the LargeInteger sum of this and the argument
     * 
     */
    public Object add(Object obj);


    /**
     * 
     * Takes a LargeInteger and returns the LargeInteger difference of this and the argument.
     * @return the LargeInteger difference of this and the argument
     * 
     */
    public Object subtract(Object obj);


    /**
     * 
     * Takes a LargeInteger and multiplies it to the incoming LargeInteger.
     * @return a LargeInteger that is the product of this and the argument
     * 
     */
    public Object multiply(Object obj);
    /**
     * Takes an object; returns 1 if this is greater than the argument, 0 if they are equal, and -1 if this is less than the argument
     * @param obj
     * @return
     */
    public byte compareTo(Object obj);
    /**
     * 
     * Returns the hash code for this list.
     * @return the hash code for this list
     * 
     */
    public int hashCode();


    /**
     * 
     * Determines if two LargeIntegers are equal.
     * @param obj The LargeInteger to compare to this list.
     * Two lists are equal if they have equal elements in the same position
     * @return true if this LargeInteger is equal to the input.
     * 
     */
    public boolean equals(Object obj);

     
    /**
     * 
     * Returns a printable representation for this list.
     * @return a printable representation for this list.
     * 
     */
    public String toString();
}