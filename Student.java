
public class Student implements Comparable{
    private Name name;
    private int score;
    private String grade;
    private String id;
    private int level;
    
    public Student(Name n, String i) {
        name = n;
        score = 0;
        grade = "E";
        id = i;
        level = 0;
    }
    
    public Student getThis() {
        return this;
    }
    public void setScore(int s) {
        score = s;
    }
    
    public void setGrade(String g) {
        grade = g;
    }
    
    public Name getName() {
        return name;
    }
    
    public void setID(String id) {
        this.id = id;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public int getScore() {
        return score;
    }
    

    
    public String getID() {
        return id;
    }


    @Override
    public int compareTo(Object arg0) {
        return this.name.compareTo( ((Student)arg0).getName() );
    }
    //id, name, score, level
    public String toString() {
        return id+ ", "+ name.toString() + ", "+"score = "+score + ", Level: "+ level;
    }
}
