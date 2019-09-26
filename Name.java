

public class Name implements Comparable{
    private String first;
    private String last;
    
    public Name(String f, String l) {
        first = f.toLowerCase();
        last = l.toLowerCase();
    }
    
    public String getFirst() {
        return first;
    }
    
    public String getLast() {
        return last;
    }
    
    public String toString() {
        return first+' '+last;
    }
    //if this is less than n, return -1
    //if equal, return 0
    //if this is bigger, return 1
    @Override
    public int compareTo(Object n) {
        if (n instanceof Name) {
            if (this.last.compareTo( ((Name)n).getLast() ) == 0) {
                return this.first.compareTo( ((Name)n).getFirst());
            }
            else 
                return this.last.compareTo( ((Name)n).last);
        }
        return 99;
    }

  
}
