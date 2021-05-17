package ferdianjulianto.jwork;

/**
 * Payment Type yang dapat digunakan
 */
public enum PaymentType {
    BankPayment("Bank Payment"),
    EwalletPayment("E-wallet Payment");

    private String payment;

    private PaymentType(String payment) {
        this.payment = payment;
    }
    
    @Override
    public String toString(){
        return payment;
    }
}