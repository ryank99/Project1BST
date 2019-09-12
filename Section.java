package Proj1BST;

public class Section {

    private int num;
    private BST roster;
    
    public Section(int i) {
        roster = new BST();
        num = i;
    }
    
    public BST getRoster() {
        return roster;
    }
    
    public int getNum() {
        return num;
    }
    
    public String toString() {
        return roster.toString();
    }
}
