package bank.card;

public class Card {
    private String cardNumber;
    private String pin;

    public Card(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + this.cardNumber + '\'' +
                ", pin='" + this.pin + '\'' +
                '}';
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public String getPin() {
        return this.pin;
    }

    public boolean verifyPin(String pin) {
        return this.pin.equals(pin);
    }
}
