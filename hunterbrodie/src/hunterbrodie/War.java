package hunterbrodie;

import java.util.ArrayList;

public class War {

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.reset();
		deck.shuffle();

		ArrayList<Card> c1 = new ArrayList<Card>();
		ArrayList<Card> c2 = new ArrayList<Card>();

		for (int x = 0; x < 26; x++)
		{
			c1.add(deck.deal());
			c2.add(deck.deal());
		}

		turn(c1, c2);

	}

	public static int turn(ArrayList<Card> c1, ArrayList<Card> c2)
	{
		Card c1card = c1.get(0);
		Card c2card = c2.get(0);
		c1.remove(0);
		c2.remove(0);

		if(c1card.getValue() > c2card.getValue())
		{
			c1.add(c1card);
			c1.add(c2card);
		}
		else if(c1card.getValue() < c2card.getValue())
		{
			c2.add(c1card);
			c2.add(c2card);
		}

		if (c1.size() == 0)
		{
			System.out.println("Computer 2 Wins");
			return 0;
		}
		else if (c2.size() == 0)
		{
			System.out.println("Computer 1 Wins");
			return 0;
		}

		turn(c1, c2);

		return 0;

	}

}
