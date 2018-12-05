/**
 * LargeInterface specifying basic LargeInt operations
 * 
 * @author Caleb Spradlin
 * @version 11/30/18
 */

public interface LargeInteger<T> extends Comparable<T>{

    /**
     * 
     * Takes a LargeInteger and returns the LargeInteger sum of this and the argument.
     * @return the LargeInteger sum of this and the argument
     * 
     */
    public LinkedLargeInteger<T> add(LinkedLargeInteger<T> input);


    /**
     * 
     * Takes a LargeInteger and returns the LargeInteger difference of this and the argument.
     * @return the LargeInteger difference of this and the argument
     * 
     */
    public LinkedLargeInteger<T> subtract(LinkedLargeInteger<T> input);


    /**
     * 
     * Takes a LargeInteger and multiplies it to the incoming LargeInteger.
     * @return a LargeInteger that is the product of this and the argument
     * 
     */
    public LinkedLargeInteger<T> multiply(LinkedLargeInteger<T> input);
    
    /**
     * Takes an object; returns 1 if this is greater than the argument, 0 if they are equal, and -1 if this is less than the argument
     * @param obj
     * @return
     */
    public int compareTo(Object obj);

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