package hunterbrodie;
import java.util.Scanner;
public class recursion {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double base = scan.nextDouble();
		int exp = scan.nextInt();
		double x = exponent(base, exp);
		System.out.println(x);
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
			return 1;
		}
	}
	
	public static double exponent(double base, int exp)
	{
		if (exp > 0)
		{
			return base * exponent(base, exp - 1);
		}
		else if (exp < 0)
		{
			return 1 / exponent(base, -1 * exp);
		}
		else
		{
			return 1;
		}
		
	}

}
