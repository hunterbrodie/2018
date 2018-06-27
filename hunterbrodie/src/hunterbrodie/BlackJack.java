package hunterbrodie;

public class BlackJack {

	public static void main(String[] args) {
		Card dcard = new Card(0, "");
		Card pcard = new Card(0, "");
		Deck deck = new Deck();
		
		Card[] dealhand = new Card[2];
		Card[] playerhand = new Card[2];
		
		for (int x = 0; x < 2; x++)
		{
			dealhand[x] = deck.deal();
			playerhand[x] = deck.deal();
		}
		
		System.out.println("The dealer's upcard is:");
		dcard = dealhand[0];
		System.out.println(dcard.fullName());
	}

}
