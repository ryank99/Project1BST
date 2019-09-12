package Proj1BST;

public class CourseManager {

    private Section[] sections;
    private int currSection = 1;
    
    public CourseManager() {
        sections = new Section[3];
        for(int i = 0; i < sections.length; i++) {
            sections[i] = new Section(i+1);
        }
    }
    
    public void section(int n) {
        System.out.println("section changed from "+currSection+" to " + n);
        currSection = n;
    }
    
    public void insert(Name n) {
        sections[currSection-1].getRoster().insert( new Student(n, generateID()) );
        System.out.println(sections[currSection-1].getRoster().toString());
    }
    
    public void remove(Name n) {
        sections[currSection].getRoster().remove(n);
    }
    
    public void removeSection(int n) {
        sections[n-1] = new Section(n);
    }
    
    public void search() {
        
    }
    
    public void score() {
        
    }
    
    public String dumpsection() {
       return(sections[currSection-1].toString());
        //inorder
    }
    
    public void grade() {
        
    }
    

    //helper function to generate ids
    public String generateID() {
        String id = "";
        if (sections.length < 10) {
            id += "0" + currSection;
        }
        int num = sections[currSection-1].getRoster().getElements()+1;
        if (num < 10) {
            id += "000";
        }
        else if (num < 100) {
            id+= "00";
        }
        else {
            id+="0";
        }
        id += (sections[currSection-1].getRoster().getElements()+1);
        return id;
    }
}
