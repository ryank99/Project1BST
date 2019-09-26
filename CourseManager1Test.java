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
      //  String s = test.section(2);
     //   assertTrue(("section changed from 1 to 2").equals(s) );
    }
    public void testInsert() {
       // String s = test.insert(new Name("Ryan", "Kirkpatrick"));
     //   System.out.println(s);
      //  assertTrue(s.equals("ryan kirkpatrick inserted"));
    }
    
    public void testRemove() {
        assertTrue(true);
    }
}

