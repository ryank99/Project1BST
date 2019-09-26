
/**
 * 
 * @author Ryan Kirkpatrick
 * @version 1
 */
public class Student implements Comparable{
    private Name name;
    private int score;
    private String grade;
    private String id;
    private int level;
    
    /**
     * 
     * @param n name
     * @param i id
     */
    public Student(Name n, String i) {
        name = n;
        score = 0;
        grade = "E";
        id = i;
        level = 0;
    }
    
    /**
     * 
     * @return this
     */
    public Student getThis() {
        return this;
    }
    
    /**
     * 
     * @param s newscore
     */
    public void setScore(int s) {
        score = s;
    }
    
    /**
     * 
     * @param g newgrade
     */
    public void setGrade(String g) {
        grade = g;
    }
    
    /**
     * 
     * @return name this.name
     */
    public Name getName() {
        return name;
    }
    
    /**
     * 
     * @param id newid
     */
    public void setID(String id) {
        this.id = id;
    }
    
    /**
     * 
     * @return currgrade
     */
    public String getGrade() {
        return grade;
    }
    
    /**
     * 
     * @return currscore
     */
    public int getScore() {
        return score;
    }
    
    /**
     * 
     * @return currid 
     */
    public String getID() {
        return id;
    }

    /**
     * @Override
     * @param arg0 object to compare to
     * @return encapsulated compareTo
     */
    public int compareTo(Object arg0) {
        return this.name.compareTo( ((Student)arg0).getName() );
    }
    
    /**
     * @return id, name, score=score
     */
    public String toString() {
        return id+ ", "+ name.toString() + ", "+"score = "+score;
    }
}