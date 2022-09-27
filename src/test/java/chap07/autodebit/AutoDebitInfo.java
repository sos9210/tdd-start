package chap07.autodebit;

import java.time.LocalDateTime;

public class AutoDebitInfo {
    private String userId;
    private String cardNumber;
    private LocalDateTime today;

    public AutoDebitInfo(String userId, String cardNumber, LocalDateTime today) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.today = today;
    }

    public AutoDebitInfo(String userId, String cardNumber) {
        this.userId = userId;
        this.cardNumber = cardNumber;
    }

    public void changeCardNumber(String cardNumber) {
    }

    public String getUserId() {
        return userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDateTime getToday() {
        return today;
    }
}
