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
			playerhand.add(deck.deal());
		}
		
		while (true)
		{
			int x = check(playerhand);
			int y = check(dealhand);
			if (x == 2 && y == 2)
			{
				System.out.println("Both have BlackJack, both tie");
				System.exit(0);
			}
			wincheck("Player", x);
			wincheck("Dealer", y);
			print(dealhand, playerhand, dealhand.size() - 1, playerhand.size());
			pturn(playerhand, deck);
			dturn(dealhand, deck);
			System.out.println();
			int z = playerhand.size();
			int i = dealhand.size();
		}

	}

	public static void print(ArrayList<Card> dealhand, ArrayList<Card> playerhand, int upcard, int pcard)
	{
		System.out.println("The dealer's upcard is:");
		for (int x = 0; x < upcard; x++)
		{
			System.out.println(dealhand.get(x).fullName());
		}

		System.out.println();
		playerprint(playerhand, pcard);
	}

	public static void playerprint(ArrayList<Card> playerhand, int pcard)
	{
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
		int size = 0;
		int valcheck = 0;
		int oval = 0;

		for (int x = 0; x < hand.size(); x++)
		{
			if (hand.get(x).getValue() == 1)
			{
				valcheck = 1;
			}
			else if(hand.get(x).getValue() > 10)
			{
				valcheck = 2;
				oval = hand.get(x).getValue();
			}
			size += hand.get(x).getValue();
		}

		size = valcheck(valcheck, size, oval);

		return size;
	}

	public static int valcheck(int val, int other, int oval)
	{
		if (val == 1)
		{
			other--;
			if (other > 10)
			{
				return other + 1;
			}
			else
			{
				return other + 11;
			}
		}
		else if (val == 2)
		{
			other = other - oval;
			int x = other + 10;
			return x;
		}
		else
		{
			return other;
		}
	}

	public static ArrayList<Card> dturn(ArrayList<Card> hand, Deck deck)
	{
		boolean turn = true;
		while (turn)
		{
			if (handsize(hand) < 17)
			{
				hand.add(deck.deal());
			}
			else
			{
				turn = false;
			}

		}

		return hand;
	}

	public static ArrayList<Card> pturn(ArrayList<Card> hand, Deck deck)
	{
		Scanner scan = new Scanner(System.in);
		boolean turn = true;

		while (turn)
		{
			System.out.println();
			System.out.println("Hit or Stay?");
			if (scan.nextLine().toLowerCase().equals("hit"))
			{
				hand.add(deck.deal());
				playerprint(hand, hand.size());
			}
			else 
			{
				turn = false;
			}

		}

		return hand;
	}
	
	public static void wincheck(String player, int x)
	{
		switch(x + 1)
		{
		case 1: System.out.println(player + " went bust, " + player +" Loses");
		System.exit(0);
		break;
		case 3: System.out.println(player + " has BlackJack, " + player + " Wins");
		System.exit(0);
		}
	}

}
