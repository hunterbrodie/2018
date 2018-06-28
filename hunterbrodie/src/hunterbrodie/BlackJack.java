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
		print(dealhand, playerhand, 1, 2);
		
		boolean turn = true;
		while(turn)
		{
			System.out.println("Hit or Stay");
			String hors = scan.nextLine();
			if()
			print(dealhand, playerhand, 1, 2);
		}
		


	}

	public static void print(ArrayList<Card> dealhand, ArrayList<Card> playerhand, int upcard, int pcard)
	{
		Card card = new Card(0,"");
		System.out.println("The dealer's upcard is:");
		for (int x = 0; x < upcard; x++)
		{
			card = dealhand.get(0);
			System.out.println(card.fullName());
		}
		
		System.out.println();
		System.out.println("Your cards are:");
		for (int x = 0; x < pcard; x++)
		{
			card = playerhand.get(x);
			System.out.println(card.fullName());
		}
	}

}
