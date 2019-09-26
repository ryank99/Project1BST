
/**
 * 
 * @author Ryan Kirkpatrick
 * @version 1
 */
public class Name implements Comparable {
    private String first;
    private String last;
    
    /**
     * 
     * @param f is first
     * @param l is last
     */
    public Name(String f, String l) {
        first = f.toLowerCase();
        last = l.toLowerCase();
    }
    
    /**
     * 
     * @return first name
     */
    public String getFirst() {
        return first;
    }
    
    /**
     * 
     * @return last name
     */
    public String getLast() {
        return last;
    }
    
    /**
     * @return string representation of name
     */
    public String toString() {
        return first + ' ' + last;
    }

    /**
     * @override
     * @param n object to compare
     * @return the int. >1 if bigger, <1 less, 0 if equal. 
     */
    public int compareTo(Object n) {
        if (n instanceof Name) {
            if (this.last.compareTo( ((Name)n).getLast() ) == 0) {
                return this.first.compareTo( ((Name)n).getFirst());
            }
            else {
                return this.last.compareTo( ((Name)n).last);
            }
        }
        return 99;
    }

  
}
