/*
Coding exercise: You are tasked to write a checker that validates the parentheses 
of a LISP code.  Write a program (in Java or JavaScript) which takes in a string 
as an input and returns true if all the parentheses in the string are properly 
closed and nested.
*/
import java.util.Scanner;
public class ParChecker {
	static char[] opar = {'(', '{', '['};
	static char[] cpar = {')', '}', ']'};

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

	//accept string in arguments
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with parenthesis");
        String input = sc.next();
        sc.close();

    	char[] chars = input.toCharArray();
    	int len = input.length();

        System.out.println(Parcheck(len, chars));
    	
    }
}