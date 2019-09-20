package Proj1BST;

public class CourseManager {

    private Section[] sections;
    private int currSection = 1;
    private Student currStudent;
    //finished(probably)
    public CourseManager() {
        sections = new Section[3];
        for(int i = 0; i < sections.length; i++) {
            sections[i] = new Section(i+1);
        }
    }
    //finished(probably)
    public String section(int n) {
        System.out.println("section changed from "+currSection+" to " + n);
        currSection = n;
        return "switch to section " + currSection;
    }
    
    //finished(probably)
    public String insert(Name n) {
        int prev = sections[currSection-1].getRoster().getElements();
        sections[currSection-1].getRoster().insert(new Student(n, generateID()));
        int curr = sections[currSection-1].getRoster().getElements();
        if (prev == curr) {
            return ""+n+" is already in section "+ currSection;
                  //  sections[currSection-1].getRoster().find(new Student(n, "")).toString();
        }
        else {
            return ""+n+" inserted";
        }
    }
    //finished(probably)
    public void remove(Name n) {
        sections[currSection-1].getRoster().remove(new Student(n, ""));
    }
    //finished(probably)
    public String removeSection(int n) {
        sections[n-1] = new Section(n);
        return "Section "+ n + " removed";
    }
    
    public String search(Name n) {
        Student x = (Student)sections[currSection-1].getRoster().find(new Student(n, ""));
        if(x == null) {
            return "Search failed. Student "+n.toString() + " doesn't exist in section " + currSection;
        }
        else {
            currStudent = x;
            return("Found "+ x.toString());

        }

    }
    
    public String multSearch(String s) {
        //iterate through and print all matching(first or last name) records
        return "";
    }
    
    
    public String score(int s) {
        if(s > 100 || s < 0) {
            return "Scores have to be integers in range 0 to 100.";
        }
        else {
            String output = "Update "+ currStudent.getName() +  " record, "+ currStudent.getScore() +" = "+ s;
            currStudent.setScore(s);
            return output;
        }
    }
    //finished(probably)
    public String dumpsection() {
       return("Section "+currSection+" dump:\n" + sections[currSection-1].toString());
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
