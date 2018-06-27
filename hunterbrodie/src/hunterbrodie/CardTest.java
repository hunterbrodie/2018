package hunterbrodie;

public class CardTest {

	public static void main(String[] args) {
		Deck deck = new Deck();
		
		deck.reset();
		deck.shuffle();
		
		for (int x = 0; x < 52; x++)
		{
			System.out.println(deck.get(x));
		}
	}

}
