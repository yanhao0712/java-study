public class Text {
    public  static void main(String[] args) {
        Payment p = new Alipay(100.0);
        p.pay();

        if (p instanceof Refundable c ) {
            c.refund();
        }
    }
}
