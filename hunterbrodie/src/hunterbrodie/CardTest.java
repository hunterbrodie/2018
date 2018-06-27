package hunterbrodie;

public class CardTest {

	public static void main(String[] args) {
		Card card = new Card(1, "Diamonds");
		System.out.println("This card is the " + card.getName() + " of " + card.getSuit());
		card.setValue(8);
		System.out.println("This card is the " + card.getName() + " of " + card.getSuit());
	}

}
