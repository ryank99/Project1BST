import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

public class Coursemanager1 {

    private static Boolean prevCommandSuccess = false;
    private static String prevCommand;
    private Section[] sections;
    private int currSection = 1;
    private Student currStudent;
    
    //finished(probably)
    public Coursemanager1() {
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

        Coursemanager1 cm = new Coursemanager1();
        
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
            line = br.readLine().trim();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        while (line != null) {
            String[] parts = line.split("\\s+");
            String func = parts[0];
            switch(func) {
                case "section": { 
                    cm.section(Integer.parseInt(parts[1]));  
                    break;
                }
                case "insert": { 
                    System.out.println(cm.insert(new Name(parts[1].toLowerCase(), parts[2].toLowerCase())));
                    break;
                }
                case "search": {
                    if(parts.length == 2) {
                        System.out.println(cm.multSearch(parts[1].toLowerCase()));
                        break;
                    }
                    else {
                    System.out.println(cm.search(
                        new Name(parts[1].toLowerCase(), parts[2].toLowerCase())));
                    break;
                    }
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
                    if(parts.length == 1) {
                        System.out.println(cm.removeSection(cm.currSection)); 
                    }
                    else {
                        System.out.println(cm.removeSection(Integer.parseInt(parts[1]))); 
                    }
                    break;
                }
                case "dumpsection": { 
                    System.out.println(cm.dumpsection()); 
                    break;
                }
                case "grade": { 
                    System.out.println(cm.grade()); 
                    break;
                }
                case "findpair": { 
                    if(parts.length == 1) {
                        System.out.println(cm.findPair(0)); 
                    }
                    else {
                        System.out.println(cm.findPair(Integer.parseInt(parts[1]))); 
                    }
                    break;
                }
            }
            try {
                String s = br.readLine();
                if(s != null) {
                    line = s.trim();
                }
                else {
                    line = null;
                }
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
    @SuppressWarnings("unchecked")
    public String insert(Name n) {
        if(search(n).contains("failed")){
            Student newGuy = new Student(n, generateID());
            sections[currSection-1].getRoster().insert(newGuy);
            currStudent = newGuy;
            return ""+n+" inserted";
        }
        else {
            Student x = (Student)sections[currSection-1].getRoster().find(new Student(n, ""));
            return ""+n+" is already in section "+ currSection + "\n" + x.toString();
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
    
    public String search(Name n) {
        @SuppressWarnings("unchecked")
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
        String ret = "Search results for "+ s+ ":\n";
        boolean found = false;
        int foundcount = 0;
        @SuppressWarnings("unchecked")
        Iterator<Student> me = sections[currSection-1].getRoster().iterator();
        while(me.hasNext()) {
            Student curr = me.next();
            if(curr.getName().getLast().equals(s)) {
                found = true;
                foundcount++;
                ret += curr.toString()+"\n";
            }
            else if(curr.getName().getFirst().equals(s)) {
                found = true;
                foundcount++;
                ret += curr.toString()+"\n";
            }
        }
        if(found) {
            ret += s+ " was found in " + foundcount + " records in section" + currSection;
        return ret;
        }
        else {
            ret+= s + "was found in 0 records in section" + currSection;
            return ret;
        }
    }
    
    
    public String score(int s) {
        if(s > 100 || s < 0) {
            return "Scores have to be integers in range 0 to 100.";
        }
        else {
            String output = "Update "+ currStudent.getName() +  " record, Score = "+ s;
            currStudent.setScore(s);
            return output;
        }
    }
    //finished(probably)
    public String dumpsection() {
       if(sections[currSection-1].getRoster().getElements() == 0) {
           return("Section " + currSection+" dump:\n"+"Size = 0");
       }
       else {
           return("Section "+currSection+" dump:\n" + sections[currSection-1].toString()
           + "\nSize = "+ sections[currSection-1].getRoster().getElements());
       }
        //inorder
    }
    
    @SuppressWarnings("unchecked")
    public String grade() {
        String ret = "Grading Completed:\n";
        Iterator<Student> me = sections[currSection-1].getRoster().iterator();
        while(me.hasNext()) {
            Student curr = me.next();
            int currScore = curr.getScore();
            String g = "E";
            if(currScore > 93) {
                g = "A+";
            }
            else if(currScore > 89) {
                g = "A-";
            }
                
            currStudent.setGrade(g);
        }
        return ret;
        //iterate through BST and asssign grade with switch statement
    }
    
    public String findPair(int x) {
        @SuppressWarnings("unchecked")
        Iterator<Student> me = sections[currSection-1].getRoster().iterator();
        ArrayList<Student> students = new ArrayList<Student>();
        int index = 0;
        int paircount = 0;
        while(me.hasNext()) {//put bst into array
            Student f = me.next();
            students.add(f);
            index++;
        }
        String ret = "Students with a score difference of less than or equal to " + x + ":\n";
        for(int i = 0; i < students.size(); i++){
           for(int j = i+1; j < students.size(); j++) {
               if (Math.abs(students.get(i).getScore() - students.get(j).getScore()) <= x) {
                   paircount++;
                   ret+= students.get(i).getName().toString() + ", "+ students.get(j).getName().toString()+"\n";
               }
           }
        }
        return ret + "found " + paircount + " pairs";
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

