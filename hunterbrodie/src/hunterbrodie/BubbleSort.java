package hunterbrodie;
import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr = new int[15];
		for (int x = 0; x < arr.length; x++)
		{
			arr[x] = rand.nextInt(50);
		}
		arr = sort(arr);
		
		for (int x = 0; x < arr.length; x++)
		{
			System.out.println(arr[x]);
		}
	}
	public static int[] sort(int[] arr)
	{
		int[] newarr = new int[arr.length - 1];
		if (arr.length == 1)
		{
			return arr;
		}
		else
		{
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
			newarr = arr;
			return  arr = sort(newarr);
		}
	}


}
