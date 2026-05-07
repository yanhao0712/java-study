import java.lang.reflect.Field;
import java.sql.SQLException;

public class User {
    private String level = "新手";
}

 class Test2{
    public static void main(String[] args) throws Exception {
        User user = new User();
        Class cla =  User.class;
        Field f  = cla.getDeclaredField("level");
        f.setAccessible(true);
        f.set(user,"大佬");
        System.out.println(f.get(user));
    }
}
