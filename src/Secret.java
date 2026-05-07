import java.io.IOException;
import java.lang.reflect.Constructor;

public class Secret {


   private String message;

   private Secret(String message){
       this.message = message;
   }
   public void show(){
       System.out.println(message);
   }
}

class Test1{
    public static void main(String[] args) throws Exception {
        Constructor con = Secret.class.getDeclaredConstructor(String.class);
        con.setAccessible(true);
        Secret secret1 = (Secret) con.newInstance("Hello");
        System.out.println(secret1);
        secret1.show();

    }
}

