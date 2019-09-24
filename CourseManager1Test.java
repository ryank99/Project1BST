package Proj1BST;
import student.TestCase;


public class CourseManager1Test extends student.TestCase{
    private CourseManager1 test;
    private String[] args;
    public void setup() {
        args = new String[] {"sampleinput.txt"};
    }
    
    public void testSampleInput() {
        CourseManager1.main(args);
        assertTrue(true);
    }
}
