package hunterbrodie;
import java.util.Random;
import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		Random rand = new Random();
			int[] arr = new int[10];
			for (int x = 0; x < arr.length; x++)
			{
				arr[x] = rand.nextInt(50);
				System.out.println(arr[x]);
			}
			System.out.println();
			arr = quicksort(arr);

			/*for (int x = 0; x < arr.length; x++)
			{
				System.out.println(arr[x]);
			}
			System.out.println("");*/
	}

	public static int[] quicksort(int[] arr)
	{
		if (arr.length > 1)
		{
			int greatnum = 0;
			int lessnum = 0;
			for (int x = 0; x < arr.length; x++)
			{
				if (arr[0] > arr[x])
				{
					greatnum++;
				}
				else if (arr[0] < arr[x])
				{
					lessnum++;
				}
			}
			int[] less = new int[lessnum];
			int[] great = new int[greatnum];
			int gz = 0;
			int lz = 0;
			for (int x = 0; x < arr.length - 1; x++)
			{
				if (arr[0] > arr[x])
				{
					great[gz] = arr[x];
					gz++;
				}
				else if (arr[0] < arr[x])
				{
					less[lz] = arr[x];
					lz++;
				}
			}
			for (int x = 0; x < great.length; x++)
			{
				System.out.println(great[x]);
			}
			System.out.println();
				//less = quicksort(less);
				//great = quicksort(great);
			/*for (int x = 0; x < great.length; x++)
			{
				System.out.println(great[x]);
			}
			System.out.println();
			for (int x = 0; x < arr.length; x++)
			{
				System.out.println(great[x]);
			}
			System.out.println("one above is arr");*/
			/*int phold = arr[0];
			for (int x = lessnum; x < greatnum; x++)
			{
				arr[x] = phold;
			}
			for (int x = 0; x < lessnum; x++)
			{
				arr[x] = less[x];
			}
			for (int x = greatnum; x < arr.length; x++)
			{
				arr[x] = great[x - greatnum];
			}*/
		}
		return arr;
	}

	public static int[] sort(int[] arr)
	{
		if (arr.length <= 1)
		{
			return arr;
		}
		else
		{
			int[] newarr = new int[arr.length - 1];
			int phold;
			for (int x = 0; x < arr.length - 1; x++)
			{
				if (arr[x] > arr[x + 1])
				{
					phold = arr[x + 1];
					arr[x + 1] = arr[x];
					arr[x] = phold;
				}

			}
			newarr = Arrays.copyOfRange(arr, 0, arr.length - 1);
			newarr = sort(newarr);
			for (int x = 0; x < newarr.length; x++)
			{
				arr[x] = newarr[x];
			}
			return arr;
		}

	}



}
