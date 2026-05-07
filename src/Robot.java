import java.lang.reflect.*;

 class FinalTest {
    public static void main(String[] args) throws Exception {
        Class<Robot> clazz = Robot.class;

        // 1. 【构造器】获取私有构造器，创建出一个名字叫 "小强" 的 Robot 对象
        // 提示：getDeclaredConstructor -> setAccessible -> newInstance
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Robot robotObj = (Robot) constructor.newInstance("小强");

        // 2. 【字段】获取私有的 "battery" 字段，把它从 10 改成 100
        // 提示：getDeclaredField -> setAccessible -> f.set(对象, 100)
        Field field = clazz.getDeclaredField("battery");
        field.setAccessible(true);
        field.set(robotObj,100);

        // 3. 【方法】获取 "work" 方法，并给它传入参数 "扫地"
        // 提示：getMethod("work", String.class) -> m.invoke(对象, "扫地")
        Method method = clazz.getDeclaredMethod("work",String.class);
        method.setAccessible(true);
        method.invoke(robotObj,"扫地");
    }
}




class Robot {
    private String name;
    private int battery = 10; // 默认电量很低

    // 私有构造器
    private Robot(String name) {
        this.name = name;
    }

    public void work(String task) {
        System.out.println(name + " 正在执行任务: " + task + "，当前电量: " + battery);
    }
}