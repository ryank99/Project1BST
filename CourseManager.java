package Proj1BST;

public class CourseManager {

    private BST[] sections;
    private int currSection = 0;
    
    public CourseManager() {
        sections = new BST[3];
        for(int i = 0; i < sections.length; i++) {
            sections[i] = new BST();
        }
    }
    
    public void section(int n) {
        currSection = n-1;
    }
    
    public void insert(Name n) {
        sections[currSection].insert( new Student(n, generateID()) );
    }
    
    public void remove(Name n) {
        sections[currSection].remove(n);
    }
    
    public void removeSection() {
        
    }
    
    public void search() {
        
    }
    
    public void score() {
        
    }
    
    public void dumpsection() {
        
    }
    
    public void grade() {
        
    }
    

    //helper function to generate ids
    public String generateID() {
        String id = "";
        if (sections.length < 10) {
            id += "0" + currSection;
        }
        id += sections[currSection].getElements();
        return id;
    }
}
