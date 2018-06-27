package hunterbrodie;
import java.util.Random;
import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr = new int[rand.nextInt(25)];
		while (true)
		{
			for (int x = 0; x < arr.length; x++)
			{
				arr[x] = rand.nextInt(50);
				System.out.println(arr[x]);
			}
			System.out.println();
			arr = quicksort(arr);

			for (int x = 0; x < arr.length; x++)
			{
				System.out.println(arr[x]);
			}
			System.out.println("");
			int[] newarr = arr;
			Arrays.sort(newarr);
			if(!(arr.equals(newarr))) {
				break;
			}
		}
	}

	public static int[] quicksort(int[] arr)
	{
		if (arr.length > 1)
		{
			int less = 0;
			int same = 1;
			int great = 0;
			for (int x = 1; x < arr.length; x++)
			{
				if(arr[0] > arr[x])
				{
					less++;
				}
				else if (arr[0] < arr[x])
				{
					great++;
				}
				else if (arr[0] == arr[x])
				{
					same++;
				}
			}
			int[] lessarr = new int[less];
			int[] greatarr =new int[great];
			int greatx = 0;
			int lessx = 0;
			for (int x = 1; x < arr.length; x++)
			{
				if(arr[0] > arr[x])
				{
					lessarr[lessx] = arr[x];
					lessx++;
				}
				else if (arr[0] < arr[x])
				{
					greatarr[greatx] = arr[x];
					greatx++;
				}
			}

			lessarr = quicksort(lessarr);
			greatarr = quicksort(greatarr);

			int phold = arr[0];
			for (int x = 0; x < less; x++)
			{
				arr[x] = lessarr[x];
			}
			for (int x = less; x < less + same; x++)
			{
				arr[x] = phold;
			}
			for (int x = 0; x < great; x++)
			{
				arr[x + less + same] = greatarr[x];
			}
		
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
