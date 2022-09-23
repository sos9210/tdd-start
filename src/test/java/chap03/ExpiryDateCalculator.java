package chap03;

import chap02.PayData;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = 1;
        if(payData.getFirstBillingDate() != null){
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
            if(payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()){
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
//            if(payData.getFirstBillingDate().equals(LocalDate.of(2019,1,31))){
//                return LocalDate.of(2019,3,31);
//            }
        }
        return payData.getBillingDate().plusMonths(addedMonths);
    }
}
