
public class Counter {
    int val;
    
    // constructor
	public Counter() {
    	val = 0;
    }
	
   // increase the value by one and return the new value
   public int increment() {
	val++;
	return val;
   }
	
   // decrease the value by one and return the value
   public int decrement() {
	val--;
	return val;
   }
}
