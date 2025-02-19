import java.util.*;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

public class CardCollection {
    private static Collection<Card> cards = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: addCard(); break;
                case 2: findCardsBySymbol(); break;
                case 3: displayAllCards(); break;
                case 4: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addCard() {
        System.out.print("Enter Card Symbol (Hearts, Diamonds, Clubs, Spades): ");
        String symbol = scanner.nextLine();
        System.out.print("Enter Card Value (e.g., Ace, 2, 3, ... King): ");
        String value = scanner.nextLine();

        cards.add(new Card(symbol, value));
        System.out.println("Card added successfully!");
    }

    private static void findCardsBySymbol() {
        System.out.print("Enter symbol to search (Hearts, Diamonds, Clubs, Spades): ");
        String symbol = scanner.nextLine();
        boolean found = false;

        System.out.println("Cards with symbol " + symbol + ":");
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found for the given symbol.");
        }
    }

    private static void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards in the collection.");
        } else {
            System.out.println("All Cards:");
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }
}

//Output:
//	Card Collection System
//	1. Add Card
//	2. Find Cards by Symbol
//	3. Display All Cards
//	4. Exit
//	Enter your choice: 1
//	Enter Card Symbol (Hearts, Diamonds, Clubs, Spades): Hearts
//	Enter Card Value (e.g., Ace, 2, 3, ... King): Ace
//	Card added successfully!
//
//	Card Collection System
//	1. Add Card
//	2. Find Cards by Symbol
//	3. Display All Cards
//	4. Exit
//	Enter your choice: 1
//	Enter Card Symbol (Hearts, Diamonds, Clubs, Spades): Hearts
//	Enter Card Value (e.g., Ace, 2, 3, ... King): 5
//	Card added successfully!
//
//	Card Collection System
//	1. Add Card
//	2. Find Cards by Symbol
//	3. Display All Cards
//	4. Exit
//	Enter your choice: 1
//	Enter Card Symbol (Hearts, Diamonds, Clubs, Spades): Clubs
//	Enter Card Value (e.g., Ace, 2, 3, ... King): Queen
//	Card added successfully!
//
//	Card Collection System
//	1. Add Card
//	2. Find Cards by Symbol
//	3. Display All Cards
//	4. Exit
//	Enter your choice: 2
//	Enter symbol to search (Hearts, Diamonds, Clubs, Spades): Hearts
//	Cards with symbol Hearts:
//	Ace of Hearts
//	5 of Hearts
//
//	Card Collection System
//	1. Add Card
//	2. Find Cards by Symbol
//	3. Display All Cards
//	4. Exit
//	Enter your choice: 3
//	All Cards:
//	Ace of Hearts
//	5 of Hearts
//	Queen of Clubs
//
//	Card Collection System
//	1. Add Card
//	2. Find Cards by Symbol
//	3. Display All Cards
//	4. Exit
//	Enter your choice: 4
//	Exiting...