package Proj1BST;

public class Student {
    private Name name;
    private int score;
    private String grade;
    private int id;
    
    public Student(Name n) {
        name = n;
        score = -1;
        grade = "E";
        id = 0;
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
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getID() {
        return id;
    }
}
