package Assignment1;

//imports
import java.util.Scanner;


/**
 * This class contains methods created for MA494 Assignment 1
 * @author Howard Numan 12300826
 */
public class MyClass {
	public int x; public int y;
	public void main(){
		while(true){
			menu();
		}
	}
	
	/**
	 * <b>menu</b>
	 * </br>
	 * <p>public void menu</p>
	 * 
	 */
	public void menu(){
		int[] fact = new int[10]; //initialize factors array
		int gcd; //for Greatest Common Denominator
		String line; //to store input from user before parsing to integers
		int num1, num2;
		
		Scanner input = new Scanner(System.in);//initializing instance of Scanner
		
		System.out.print("Enter a integer or two integers between range (1 - 100).\ninput: ");
		
		//if input has a integers for parameters
		if(input.hasNextInt()){
			line = input.nextLine();//get user input as string
			
			//if the line has two arguments separated by a whitespace
			if(line.split(" ").length > 1 && line.split(" ").length <= 2){
				num1 = Integer.parseInt(line.split(" ")[0]); //get the first number separated by whitespace
				num2 = Integer.parseInt(line.split(" ")[1]); //get the second number after whitespace
				gcd = get_GCD(num1, num2);
				System.out.println("The greatest common denominator of " + num1 + " and " + num2 + " is: " + gcd);
				System.exit(0);
				
			}
			//if the line has only argument
			else if(line.split(" ").length > 0 && line.split(" ").length < 2){
				num1 = Integer.parseInt(line); //parse the single integer
				fact = get_factors(num1); //get the factors of the single integer
				
				//uses printArr function to print the factors of single number
				printArr(fact);
				System.exit(0);
			}
			//if the line does not have an argument
			else{
				System.out.println("to exit enter \"quit\" without the quotes.");
				input.close();
				menu();
			}
			
		}
		//if input has the word "quit" in it
		else if(input.hasNext("quit")){
			System.out.println("\n\nclosing program...");
			System.exit(0);
		}
		//anything not matching the previous two conditions
		else{
			System.out.println("\nto exit program type \"quit\" without the quotes");
			input.close();
			menu();
		}
		
	}
	
	/**
	 * <b>get_factors </b>
	 * <br>
	 * 
	 * get_factors returns factors of an integer x
	 * range of integer x: range (1 - 100)
	 * 
	 * @param int x
	 * @return an int array[10] containing factors of an int x
	 */
	public int[] get_factors(int x){
		int[] factors = new int[10]; int count = 0;
		
		for(int i = 1; i <= x; i++){
			if(x%i == 0){
				factors[count] = i; count++;
			}
		}
		
		return factors;
	}//end of get_factors
	
	/**
	 * get_GCD returns an integer which is the greatest or highest
	 * common factor for two integer numbers
	 * range of integer parameters: range(1 - 100)
	 * 
	 * @param int x
	 * @param int y
	 * 
	 * @return an integer which is the GCD of two integers
	 */
	public int get_GCD(int x, int y){ 
		 //initializes array (gcdArr) and prepares its counter (count)
		int[] gcdArr = new int[10]; int count = 0;
		//initializes arrays (xArr and yArr) for holding factors of x and y
		int[] xArr = new int[10]; int[] yArr = new int[10];
		xArr = get_factors(x); yArr = get_factors(y); //gets the factors of x and y
		
		//searches through both arrays (xArr and yArr)
		//saves common factors to another (gcdArr)
		//
		//if the array values are zero we've reach the end 
		//of array so we break out of loop
		for(int e1: xArr ){
			if(e1 == 0){
				break;
			}
			
			for(int e2: yArr){
				if(e2 == 0){
					break;
				}
				
				if(e1 == e2){
					gcdArr[count] = e1; count++;
				}
				
			}//for e2: yArr)
			
		}//for (int e1: xArr)
		
		//since the arrays are created in ascending order
		//it is safe to assume that the last element in gcdArr
		// is the highest common denominator so return
		return gcdArr[count-1]; 
	}//end of get_GCD
	
	/**
	 * Prints the contents of factors array.
	 * Since an integer can not have zeros as factors, the function
	 * quits as when it reads zeros in the function.
	 * 
	 * @param int[] arr
	 * 
	 */
	public void printArr(int[] arr){
		for(int e: arr){
			if(e == 0){
				break;
			}
			System.out.print(e + " ");
			
		}
	}//end of printArr
	
}
