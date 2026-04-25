




class Payment{
    void pay(double amount){
        System.out.println("正在发起通用支付"+amount);
    }
}


class Alipay extends Payment{
    @Override
    void pay(double amount){
        System.out.println("这是支付宝" + amount);
    }
    void scanFace(){
        System.out.println("可以扫脸支付");
    }
}

class WechatPay extends Payment{
    @Override
    void pay(double amount){
        System.out.println("这是微信支付" + amount);
    }
    void redPacket(){
        System.out.println("你可以发红包");
    }
}

public class PaymentSystem{

        public static void progressPayment(Payment p ,double money){
            if(p == null){
                System.out.println("无效");
                return;
            }
            p.pay(money);
            if( p instanceof Alipay ap){

                ap.scanFace();
            } else if (p instanceof WechatPay wp) {

                wp.redPacket();

            }


        }

    public static void main(String[] args){
        Payment p = new Alipay();
        Payment p2 = new WechatPay();
        progressPayment(p,100.0);
        progressPayment(p2,200.0);
    }
}


