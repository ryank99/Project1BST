package Proj1BST;

import java.util.Iterator;
import java.io.*;

public class CourseManager1 {

    private static Boolean prevCommandSuccess = false;
    private static String prevCommand;
    private Section[] sections;
    private int currSection = 1;
    private Student currStudent;
    
    //finished(probably)
    public CourseManager1() {
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

        CourseManager1 cm = new CourseManager1();
        
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
                    System.out.println(cm.findPair(Integer.parseInt(parts[1]))); 
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
    public String section(int n) {
        System.out.println("section changed from "+currSection+" to " + n);
        currSection = n;
        return "switch to section " + currSection;
    }
    
    //finished(probably)
    public String insert(Name n) {
        int prev = sections[currSection-1].getRoster().getElements();
        Student newGuy = new Student(n, generateID());
        sections[currSection-1].getRoster().insert(newGuy);
        int curr = sections[currSection-1].getRoster().getElements();
        if (prev == curr) {
            return ""+n+" is already in section "+ currSection;
                  //  sections[currSection-1].getRoster().find(new Student(n, "")).toString();
        }
        else {
            currStudent = newGuy;
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
        s = s.toLowerCase();
        String ret = "Search results for name\n";
        Iterator<Student> me = sections[currSection-1].getRoster().iterator();
        while(me.hasNext()) {
            Student curr = me.next();
            if(curr.getName().getLast().equals(s)) {
                ret += curr.toString();
            }
            else if(curr.getName().getFirst().equals(s)) {
                ret += curr.toString();
            }
        }
        return ret;
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
        //iterate through BST and asssign grade with switch statement
    }
    
    public String findPair(int x) {
        Iterator<Student> me = sections[currSection-1].getRoster().iterator();
        Student[] students = new Student[sections[currSection-1].getNum()];
        int index = 0;
        while(me.hasNext()) {//put bst into array
            students[index] = me.next();
            index++;
        }
        String ret = "Students with a score difference of less than or equal to" + x + "\n";
        for(int i = 0; i < students.length; i++){
           for(int j = i+1; j < students.length; j++) {
               if (students[i].getScore() - students[j].getScore() <= x) {
                   ret+= students[i].getName().toString() + "\n";
                   
               }
           }
        }
        return ret;
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
