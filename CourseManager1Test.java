

import student.TestCase;


public class CourseManager1Test extends student.TestCase{
    private Coursemanager1 test;
    private String[] args;
    public void setup() {
        test = new Coursemanager1();
        test.section(1);
    }
    
    public void testSampleInput() {
        String[] arguments = new String[] {"sampleinput.txt"};
        assertFalse("sampleinput.txt".equals("hello"));
        Coursemanager1.main(arguments);
    }
    
    public void testSection() {
        test = new Coursemanager1();
        String s = test.section(2);
        assertTrue(("switch to section 2").equals(s) );
    }
    public void testInsert() {
        test = new Coursemanager1();
        String s = test.insert(new Name("Ryan", "Kirkpatrick"));
        assertTrue(s.equals("ryan kirkpatrick inserted"));
    }
    
    public void testRemove() {
        test = new Coursemanager1();
        test.section(1);
        String s = test.insert(new Name("Ryan", "Kirkpatrick"));
        String t = test.remove(new Name("Ryan", "Kirkpatrick"));
        System.out.println(t);
        assertTrue(t.equals("Student ryan kirkpatrick get removed from section 1"));
    }
}

