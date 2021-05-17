package ferdianjulianto.jwork;

/**
 *  InvoiceStatus yang bisa digunakan
 */

public enum InvoiceStatus {
    OnGoing("OnGoing"),
    Finished("Finished"),
    Cancelled("Cancelled");

    private String invoice;
    
    private InvoiceStatus(String invoice) {
        this.invoice = invoice;
    }
    
    @Override
    public String toString(){
        return invoice;
    }
}
