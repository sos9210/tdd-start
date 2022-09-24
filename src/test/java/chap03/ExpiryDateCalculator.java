package chap03;

import chap02.PayData;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = getAddedMonths(payData);
        if(payData.getFirstBillingDate() != null){
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        }else{
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private int getAddedMonths(PayData payData) {
        int addedMonths;
        if(payData.getPayAmount() % 100_000 == 0){
            addedMonths = payData.getPayAmount() == 100_000 ? 12 : payData.getPayAmount() / 10_000;
        }else{
            int serviceOfferYear = payData.getPayAmount() / 100_000;
            addedMonths = serviceOfferYear * 12 + (payData.getPayAmount() - serviceOfferYear*100_000) / 10_000;
        }
        return addedMonths;
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        if(isSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)){
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
            final int dayOfFirstBillings = payData.getFirstBillingDate().getDayOfMonth();
            if(dayLenOfCandiMon < dayOfFirstBillings){
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBillings);
        }
        return candidateExp;
    }

    private int lastDayOfMonth(LocalDate candidateExp) {
        return YearMonth.from(candidateExp).lengthOfMonth();
    }

    private boolean isSameDayOfMonth(LocalDate data1, LocalDate candidateExp) {
        return data1.getDayOfMonth() != candidateExp.getDayOfMonth();
    }
}
