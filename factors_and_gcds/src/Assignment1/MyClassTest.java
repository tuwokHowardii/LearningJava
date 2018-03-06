package Assignment1;

import static org.junit.Assert.*;
import org.junit.Test;


public class MyClassTest {
	public static void main(String[] args){
		
	}
	
	MyClass testClass = new MyClass();
	@Test
	public void get_GCDtest(){
		int x = 10;
		int y = 15;
		
		assertEquals("The GCD for " + x + " and " + y, 5, testClass.get_GCD(x,y));
		assertEquals("The GCD for " + x + " and 100", 10, testClass.get_GCD(x, 100));
		assertEquals("The GCD for 73 and " + y, 1, testClass.get_GCD(73, y));
	}
	
	@Test
	public void get_factorsTest(){
		
	}
	
	

}
