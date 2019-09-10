package Proj1BST;

public class Student implements Comparable{
    private Name name;
    private int score;
    private String grade;
    private String id;
    
    public Student(Name n, String i) {
        name = n;
        score = -1;
        grade = "E";
        id = i;
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
}
