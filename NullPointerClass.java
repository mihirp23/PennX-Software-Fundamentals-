
import java.util.*;

// class example
// illustrates a NullPointerException error , which happens 
// when trying to access an instance variable or a method
// from an object that is null


public class NullPointerClass {
    ArrayList<Integer> ints;
    
    public int getNumInts() {
        return ints.size();
    }
    
    public static void main (String [] args) {
    	NullPointerClass npc = new NullPointerClass();
    	System.out.println(npc.getNumInts());
    }
}
