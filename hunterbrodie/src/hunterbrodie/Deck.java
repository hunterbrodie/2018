package hunterbrodie;

import java.util.Random;

public class Deck {

	private Card[] cards;
	private int dealcount;

	public Deck()
	{
		cards = new Card[52];
	}

	public void reset()
	{
		dealcount = 0;
		String suitName = "";
		int z = 0;
		for (int x = 1; x <= 4; x++)
		{
			switch (x)
			{
			case 1: suitName = "Hearts";
			break;
			case 2: suitName = "Diamonds";
			break;
			case 3: suitName = "Clubs";
			break;
			case 4: suitName = "Spades";
			}
			for (int y = 1; y < 14; y++)
			{
				Card card = new Card(y, suitName);
				cards[z] = card;
				z++;
			}
		}
	}

	public String get(int x)
	{
		Card card = new Card(x, "Spades");
		card = cards[x];
		return card.fullName();
	}

	public void shuffle()
	{
		Random rand = new Random();

		for (int x = 0; x < 52; x++)
		{
			Card phold;
			int x1 = rand.nextInt(52);
			int x2 = rand.nextInt(52);
			phold = cards[x1];
			cards[x1] = cards[x2];
			cards[x2] = phold;
		}
	}

	public Card deal()
	{
		Card card = new Card(0, "");
		if (dealcount == 52)
		{
			reset();
			shuffle();
			dealcount = 0;
		}
		
		card = cards[dealcount];
		dealcount++;

		return card;
	}

}
