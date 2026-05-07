import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Exercise22 {
    public static void main(String[] args) throws Exception {
        User2 user = new User2();
        Class cla =  User2.class;
        Field field = cla.getDeclaredField("name");
        field.setAccessible(true);
        field.set(user,"大佬");

        Field field1 = cla.getDeclaredField("age");
        field1.setAccessible(true);
        field1.set(user,20);

        Constructor constructor = cla.getDeclaredConstructor();
        constructor.setAccessible(true);
        User2 user1 = (User2) constructor.newInstance();
        // 1. 获取所有的属性（复数形式！）
        Field[] fields = cla.getDeclaredFields();

// 2. 开始循环克隆
        for (Field f : fields) {
            f.setAccessible(true); // 保证私有属性也能动

            // 关键动作 A：从【原件】里读取值
            Object value = f.get(user);

            // 关键动作 B：把读到的值塞进【副本】里
            f.set(user1, value);
        }

// 3. 验证结果
        user1.show();




    }
}




class User2 {
    private String name = "默认名";
    private int age = 18;

    // 为了验证结果，我留了一个无参构造
    public User2() {}

    public void show() {
        System.out.println("克隆后的结果 -> 姓名: " + name + "，年龄: " + age);
    }
}