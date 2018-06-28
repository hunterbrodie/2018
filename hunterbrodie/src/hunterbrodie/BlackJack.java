package hunterbrodie;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Card card = new Card(0, "");
		Deck deck = new Deck();
		deck.reset();
		deck.shuffle();

		ArrayList<Card> dealhand = new ArrayList<Card>();
		ArrayList<Card> playerhand = new ArrayList<Card>();

		for (int x = 0; x < 2; x++)
		{
			dealhand.add(deck.deal());
		}

		card.setValue(1);
		playerhand.add(card);
		card.setValue(13);
		playerhand.add(card);
		print(dealhand, playerhand, 1, 2);

		boolean turn = true;
		boolean dturn = true;
		int pcardnum = 2;
		int upcard = 1;
		while(dturn)
		{
			if(turn == true)
			{
				if(check(playerhand) == 2)
				{
					System.out.println("Player got BlackJack!");
					turn = false;
					dturn = false;
					break;
				}
				if(check(dealhand) == 2)
				{
					System.out.println("Dealer got BlackJack!");
					turn = false;
					dturn = false;
					break;
				}
				System.out.println();
				System.out.println("Hit or Stay");
				String hors = scan.nextLine();
				if(hors.toLowerCase().equals("hit"))
				{
					playerhand.add(deck.deal());
					print(dealhand, playerhand, upcard, pcardnum);
					pcardnum++;
				}
				else
				{
					turn = false;
				}

			}
			else
			{
				int size = handsize(dealhand);
				if(size >= 17)
				{
					dturn = false;
				}
				else
				{
					dealhand.add(deck.deal());
					upcard++;
				}
			}
		}
		
		print(dealhand, playerhand, upcard, pcardnum);

	}

	public static void print(ArrayList<Card> dealhand, ArrayList<Card> playerhand, int upcard, int pcard)
	{
		System.out.println("The dealer's upcard is:");
		for (int x = 0; x < upcard; x++)
		{
			System.out.println(dealhand.get(x).fullName());
		}

		System.out.println();
		System.out.println("Your cards are:");
		for (int x = 0; x < pcard; x++)
		{
			System.out.println(playerhand.get(x).fullName());
		}
	}

	public static int check(ArrayList<Card> hand)
	{
		int y = handsize(hand);
		
		if(y > 21)
		{
			return 0;
		}
		else if (y == 21 && hand.size() == 2)
		{
			return 2;
		}
		else 
		{
			return 1;
		}
	}
	
	public static int handsize(ArrayList<Card> hand)
	{
		Card check = new Card(0, "");
		int size = 0;
		
		for (int x = 0; x < hand.size(); x++)
		{
			int asize = 0;
			if (hand.get(x).getValue() > 10)
			{
				asize = 10;
			}
			else if (hand.get(x).getValue() == 1)
			{
				asize = 11;
			}
			else
			{
				asize = hand.get(x).getValue();
			}
			size += asize;
		}
		
		return size;
	}

}
