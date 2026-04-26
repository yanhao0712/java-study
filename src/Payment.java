public abstract class Payment {
    double amount;
    public Payment(double amount) {
        this.amount = amount;
    }
    public abstract void pay();
}

 interface Refundable{
    void refund();
}



class Alipay extends Payment implements Refundable{
    public Alipay(double amount) {
        super(amount);
    }
    @Override
    public void refund() {
        System.out.println("可以退款" + amount);
    }
    @Override
    public void pay() {
        System.out.println("可以支付"+amount);
    }
}

class CreditCard extends Payment {
    public CreditCard(double amount) {
        super(amount);
    }
    @Override
    public void pay() {
        System.out.println("可以付"+amount);
    }
}








