import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
    String value();

}


class Robot1{
    @Inject("小艺")
    private String name;
    @Inject("X-2026")
    private String model;
    public Robot1() {

    }
    public void show() {
        System.out.println(name);
        System.out.println(model);

    }
}




class InjectDemo{
    public static void main(String[] args) throws Exception {
        Robot1 robot = new Robot1();
        Class cla =  Robot1.class;
        Field [] field = cla.getDeclaredFields();

        for (Field field1 : field) {
            field1.setAccessible(true);
            if(field1.isAnnotationPresent(Inject.class)) {
                Inject inject = field1.getAnnotation(Inject.class);
                String value = inject.value();
                field1.set(robot,value);
            }
        }
        robot.show();
    }

}



