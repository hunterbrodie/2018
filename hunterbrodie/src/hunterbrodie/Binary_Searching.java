package hunterbrodie;
import java.util.Scanner;

public class Binary_Searching {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = new int[11];
		for (int x = 0; x < 11; x++)
		{
			array[x] = x * 2;
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
		if ((array.length % 2) == 1 || x > 0)
		{
			if (target == array[x])
			{
				return true;
			}
			else if (target < array[x])
			{
				if (array.length % 2 == 1)
				{
					x++;
				}

				int[] newarray = new int[x];

				for (int y = 0; y < x; y++)
				{
					newarray [y] = array [y];
				}
				return search(newarray, target);
			}
			else if (target > array[x])
			{
				if (array.length % 2 == 1)
				{
					x++;
				}

				int[] newarray = new int[x];

				for (int y = 0; y < x; y++)
				{
					newarray[y] = array [y + x - 1];
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
