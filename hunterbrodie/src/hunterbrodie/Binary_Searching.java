package hunterbrodie;
import java.util.Scanner;

public class Binary_Searching {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arrlength = 11;
		int[] array = new int[arrlength];
		for (int x = 0; x < arrlength; x++)
		{
			array[x] = x * 2 + 1;
		}
		while (true)
		{
			int input = scan.nextInt();
			boolean res = search(array, input);
			System.out.println(res);
		}
	}

	public static boolean search(int[] array, int target)
	{
		int x = array.length / 2;
		if (target == array[x])
		{
			return true;
		}
		if (array.length > 1)
		{
			if (target < array[x])
			{
				x += (array.length % 2);

				int[] newarray = new int[x];

				for (int y = 0; y < x; y++)
				{
					newarray [y] = array [y];
				}
				return search(newarray, target);
			}
			else if (target > array[x])
			{
				int[] newarray = new int[x];

				for (int y = 0; y < x; y++)
				{
					newarray[y] = array [y + x + (array.length % 2)];
				}
				return search(newarray, target);
			}
			else 
			{
				return false;
			}

		}
		else
		{
			return false;
		}
	}

}
