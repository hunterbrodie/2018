package hunterbrodie;
import java.util.Scanner;
public class recursion {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int x = factorial(input);
	}

	public static int countdown(int input)
	{
		if(input > 0)
		{
			System.out.println(input);
			input--;
			return countdown(input);
		}
		else if(input < 0)
		{
			System.out.println(input);
			input++;
			return countdown(input);
		}
		else
		{
			System.out.println(0);
			return 0;
		}

	}
	
	public static int factorial(int input)
	{
		if (input > 1)
		{
			return input * factorial(input - 1);
		}
		else
		{
			System.out.println(input);
			return 0;
		}
	}

}
