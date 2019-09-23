package Proj1BST;
import java.io.*;

public class CourseManager {

    private static Boolean prevCommandSuccess = false;
    private static String prevCommand;
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
    public static void main(String[] args) 
    {
        if (args.length != 1) {
            throw(new Error("Invalid number of program arguments"));
        }

        CourseManager cm = new CourseManager();
        
        String commandFileName = args[0];
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(commandFileName));
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line = null;
        try {
            line = br.readLine();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        while (line != null) {
            String[] parts = line.split(" ");
            String func = parts[0];
            switch(func) {
                case "section": { 
                    cm.section(Integer.parseInt(parts[1]));  
                    break;
                }
                case "insert": { 
                    System.out.println(cm.insert(new Name(parts[1], parts[2])));
                    break;
                }
                case "search": {  
                    System.out.println(cm.search(new Name(parts[1], parts[2])));
                    break;
                } 
                case "score": { 
                    System.out.println(cm.score(Integer.parseInt(parts[1])));
                    break;
                }
                case "remove": { 
                    cm.remove(new Name(parts[1], parts[2])); 
                    break;
                }
                case "removesection": { 
                    System.out.println(cm.removeSection(Integer.parseInt(parts[1]))); 
                    break;
                }
                case "dumpsection": { 
                    System.out.println(cm.dumpsection()); 
                    break;
                }
                case "grade": { 
                    cm.grade(); 
                    break;
                }
                case "findpair": { 
                    System.out.println(cm.findpair(parts[1])); 
                    break;
                }
            }
            try {
                line = br.readLine();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            prevCommand = func;
        }
    }
    //finished(probably)
    public void section(int n) {
        prevCommand = "section";
        System.out.println("section changed from "+currSection+" to " + n);
        currSection = n;
    }
    
    //finished(probably)
    @SuppressWarnings("unchecked")
    public String insert(Name n) {
        currStudent = new Student(n, generateID());
        int prev = sections[currSection-1].getRoster().getElements();
        sections[currSection-1].getRoster().insert(currStudent);
        int curr = sections[currSection-1].getRoster().getElements();
        if (prev == curr) {
            prevCommandSuccess = false;
            return ""+n+" is already in section "+ currSection;
                  //  sections[currSection-1].getRoster().find(new Student(n, "")).toString();
        }
        else {
            prevCommandSuccess = true;
            return ""+n+" inserted";
        }
    }
    //finished(probably)
    @SuppressWarnings("unchecked")
    public void remove(Name n) {
        sections[currSection-1].getRoster().remove(new Student(n, ""));
    }
    //finished(probably)
    public String removeSection(int n) {
        sections[n-1] = new Section(n);
        return "Section "+ n + " removed";
    }
    
    @SuppressWarnings("unchecked")
    public String search(Name n) {
        Student x = (Student)sections[currSection-1].getRoster().find(new Student(n, ""));
        if(x == null) {
            prevCommandSuccess = false;
            return "Search failed. Student "+n.toString() + " doesn't exist in section " + currSection;
        }
        else {
            prevCommandSuccess = true;
            currStudent = x;
            return("Found "+ x.toString());

        }

    }
    
    public String findpair(String s) {
        //iterate through and print all matching(first or last name) records
        return "";
    }
    
    
    public String score(int s) {
        if(s > 100 || s < 0) {
            return "Scores have to be integers in range 0 to 100.";
        }
        else {
            if (prevCommand.equals("insert") || (prevCommand.equals("search") && prevCommandSuccess == true)) {
                String output = "Update "+ currStudent.getName() +  " record, "+ currStudent.getScore() +" = "+ s;
                currStudent.setScore(s);
                return output;
            }
            return "Score command must come after an insert command or a successful search command";
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
