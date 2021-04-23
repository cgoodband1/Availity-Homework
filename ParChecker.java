/*
Coding exercise: You are tasked to write a checker that validates the parentheses 
of a LISP code.  Write a program (in Java or JavaScript) which takes in a string 
as an input and returns true if all the parentheses in the string are properly 
closed and nested.
*/
import java.util.Scanner;
public class ParChecker {
	//arrays containing symbols to check for pair.
	static char[] opar = {'(', '{', '['};
	static char[] cpar = {')', '}', ']'};
	
	//function to check if char is open symbol returns 1 if true and 0 if false. 
	public static int open_check(char test, char[] array){

		for(int i = 0; i<3; i++)
		{
			if(test == array[i])
			{
				return 1;
			}
		} 
		return 0;
	}
	//function to check if char is open symbol returns 1 if true and 0 if false. 
	public static int closed_check(char test,char[] array){

		for(int i = 0; i<3; i++)
		{
			if(test == array[i])
			{
				return 1;
			}
		} 
		return 0;
	}

	//function to determine if there are a pair of symbols. 
	//returns Boolean by calling open and closed check and adding or subtracting to par variable.
    public static Boolean Parcheck(int len, char[] chars)
    {
        int par = 0;
        int open = 0;
        int closed = 0;
        for(int i = 0; i<len; i++){

            //char ch = name.charAt(i);

            open = open_check(chars[i],opar);
            if(open == 1)
            {
                par++;
            }
            closed = closed_check(chars[i],cpar);
            if(closed == 1)
            {
                par--;
            }
        }
        if(par == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    
	//asks user to enter string with parenthesis
        System.out.println("Enter a string with parenthesis");
	//read input with scanner
        String input = sc.next();
        sc.close();
	//change string to char array
    	char[] chars = input.toCharArray();
    	int len = input.length();
	//call Parcheck function inside of print statement to print out the Boolean returned.
        System.out.println(Parcheck(len, chars));
    	
    }
}
